package accountsMerge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Stream.of("John", "johnsmith@mail.com", "john00@mail.com").collect(Collectors.toList()));
        accounts.add(Stream.of("John", "johnsmith@mail.com", "john_newyork@mail.com").collect(Collectors.toList()));
        accounts.add(Stream.of("John", "johnnybravo@mail.com").collect(Collectors.toList()));
        accounts.add(Stream.of("Mary", "mary@mail.com").collect(Collectors.toList()));


        List<List<String>> result = s.accountsMerge(accounts);
        result.forEach(e-> {
            System.out.println();
            e.forEach(element -> System.out.print(element));
        });
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if(accounts.size() == 0) {return new ArrayList();}

        Map<String, Set<String>> graph = new HashMap();

        Map<String, String> nameToEmail = new HashMap();

        for(List<String> emails : accounts) {

            String name = "";

            for(int i =0; i<emails.size(); i++) {
                String email = emails.get(i);
                if("".equals(name)) {
                    name = email;
                    continue;
                }


                if(!graph.containsKey(email)) {
                    graph.put(email, new HashSet());
                }
                graph.get(email).add(email);

                String first = emails.get(1);
                if(graph.containsKey(first)) {
                    graph.get(first).add(email);
                }

                nameToEmail.put(email, name);

            }
        }


        Stack<String> stack = new Stack();
        List<List<String>> result = new ArrayList();
        Set<String> visited = new HashSet();
        for(String email: graph.keySet()) {

            if(visited.add(email)) {
                List<String> components = new ArrayList();
                components.add(email);
                dfs(graph, visited, email, components);
                Collections.sort(components);
                String name = nameToEmail.get(email);
                components.add(0, name);
                result.add(components);
            }
        }
        return result;
    }

    private void dfs( Map<String, Set<String>> graph , Set<String> visited, String node, List<String> nodes) {


        for(String email: graph.get(node)) {
            if(!visited.contains(email)) {
                visited.add(email);
                nodes.add(email);
                dfs(graph, visited, email, nodes);
            }
        }
    }

    /*public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap();
        Map<String, ArrayList<String>> graph = new HashMap();
        for (List<String> account: accounts) {
            String name = "";
            for (String email: account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                graph.computeIfAbsent(email, x-> new ArrayList<String>()).add(account.get(1));
                graph.computeIfAbsent(account.get(1), x-> new ArrayList<String>()).add(email);
                emailToName.put(email, name);
            }
        }

        Set<String> seen = new HashSet();
        List<List<String>> ans = new ArrayList();
        for (String email: graph.keySet()) {
            if (!seen.contains(email)) {
                seen.add(email);
                Stack<String> stack = new Stack();
                stack.push(email);
                List<String> component = new ArrayList();
                while (!stack.empty()) {
                    String node = stack.pop();
                    component.add(node);
                    for (String nei: graph.get(node)) {
                        if (!seen.contains(nei)) {
                            seen.add(nei);
                            stack.push(nei);
                        }
                    }
                }
                Collections.sort(component);
                component.add(0, emailToName.get(email));
                ans.add(component);
            }
        }
        return ans;
    }*/
}
