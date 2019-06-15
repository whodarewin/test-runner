package com.hc.test.runner.scanner;

import java.util.List;

/**
 * Created by congcong.han on 2019/6/7.
 */
public class MethodInfo implements Comparable<MethodInfo>{
    private String name;
    private List<String> paramTypes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(List<String> paramTypes) {
        this.paramTypes = paramTypes;
    }


    @Override
    public int compareTo(MethodInfo o) {
        if(o == null){
            return 1;
        }
        int nameCompare = name.compareTo(o.getName());
        if(nameCompare == 0){
            int thisParamNumerLen = this.paramTypes == null ? 0 : this.paramTypes.size();
            int otherParamNumerLen = o.getParamTypes() == null ? 0 : o.getParamTypes().size();
            if(thisParamNumerLen == 0 && otherParamNumerLen == 0){
                return 0;
            }
            if(thisParamNumerLen == otherParamNumerLen){
                for(int i = 0; i < otherParamNumerLen; i ++){
                    String thisParam = paramTypes.get(i);
                    String otherParam = o.getParamTypes().get(i);
                    int compareResult = thisParam.compareTo(otherParam);
                    if(compareResult == 0){
                        continue;
                    }else{
                        return compareResult;
                    }
                }
            }
        }
        return 0;
    }
}
