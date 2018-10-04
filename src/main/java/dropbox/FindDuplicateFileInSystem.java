package dropbox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {

        List<List<String>> ans = new ArrayList<>();
        if(paths==null || paths.length==0) {
            return ans;
        }

        Map<String, List<String>> map = new HashMap<>();

        for(String input: paths) {
            parseInput(input, map);
        }

        for(List<String> cur: map.values()) {

            if(cur.size()>1) {
                ans.add(cur);
            }

        }

        return ans;
    }


    private void parseInput(String paths, Map<String, List<String>> map) {
        String[] token = paths.split("\\s+");
        String filePathPrefix = token[0] + "/";

        for(int i=1; i<token.length; i++) {

            String[] fileNameAndContent = token[i].split("\\(");
            String filePath = filePathPrefix+fileNameAndContent[0];
            String fileContent = fileNameAndContent[1].substring(0, fileNameAndContent[1].length()-1);
            List<String> fileList = map.getOrDefault(fileContent, new ArrayList<>());
            fileList.add(filePath);
            map.put(fileContent, fileList);
        }

    }
}
