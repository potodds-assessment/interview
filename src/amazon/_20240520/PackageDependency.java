package amazon._20240520;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

/*
{
    "A": ["B", "D"],
    "B": [],
    "C": [],
    "D": ["C"],
    "E": ["F"],
    "F": ["E"]
}
// "A" -> "B", "C", "D", "A"
*/

public class PackageDependency {
    List<String> ans = new ArrayList<>();

/*
 * Stack doesn't work

    Stack<String> stk = new Stack<>();

    public void addDep(Map<String, List<String>> mapDep, List<String> dep) {
        if (dep == null || dep.size() == 0)
            return;

        for(String d : dep) {
            stk.push(d);
            addDep(mapDep, mapDep.get(d));
        }
    }

    public List<String> findDependencies(Map<String, List<String>> mapDep, String key) {

        stk.push(key);
        addDep(mapDep, mapDep.get(key));

        while (!stk.isEmpty()) 
            ans.add(stk.pop());    

        return ans;
    }
 */


    public void findBase(Map<String, List<String>> mainList, List<String> deps, Set<String> visited) 
        throws Exception {
        if (deps == null || deps.size() == 0)
            return;
        
        for(String dep : deps) {                
            if (visited.contains(dep))
                throw new Exception("cyclic reference:" + dep);
    
            visited.add(dep);
            findBase(mainList, mainList.get(dep), visited);
            System.out.println("adding/visiting:" + dep);
            ans.add(dep);
        }
    }
    
    public List<String> findDependencies(Map<String, List<String>> mapDep, String key) {
        Set<String> visited = new HashSet<>();
    
        try {
            System.out.println("finding " + key);
            List<String> dep = mapDep.get(key);
            visited.add(key);
            findBase(mapDep, dep, visited);
            ans.add(key);
        } catch(Exception e)  {
            e.printStackTrace();
        }
        
        return ans;
    }

    public static void main(String[] args) {
        Map<String, List<String>> dependencies = new HashMap<>();
        dependencies.put("A", List.of("B", "D"));
        dependencies.put("B", new ArrayList<>());
        dependencies.put("C", List.of("E"));
        dependencies.put("D", List.of("C"));
        dependencies.put("E", new ArrayList<>());
        dependencies.put("F", List.of("G"));

        PackageDependency app = new PackageDependency();
        List<String> ans = app.findDependencies(dependencies, "A");
        System.out.println(ans);

/*
{
    "A": ["B", "D"],
    "B": [],
    "C": [],
    "D": ["C"],
    "E": ["F"],
    "F": ["E"]
}
// "A" -> "B", "C", "D", "A"
*/

        
    }
}
