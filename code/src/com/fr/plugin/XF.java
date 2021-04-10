package com.fr.plugin;

import com.fr.plugin.transform.ExecuteFunctionRecord;
import com.fr.plugin.transform.FunctionRecorder;
import com.fr.script.AbstractFunction;

@FunctionRecorder
public class XF extends AbstractFunction {
    public static int getGongYueShu(int a, int b) {
        int t = 0;
        if(a < b){
            t = a;
            a = b;
            b = t;
        }
        int c = a % b;
        if(c == 0){
            return b;
        }else{
            return getGongYueShu(b, c);
        }
    }

    @Override
    @ExecuteFunctionRecord
    public Object run(Object[] args) {
        String result = "";
        Object para;
        for (int i = 0; i < args.length; i++) {
            para = args[i].toString();
            String[] array = new String[2];
            array = ((String) para).split("\\.");
            int a = Integer.parseInt(array[0]);
            int b = Integer.parseInt(array[1]);
            int length = array[1].length();
            int FenZi = (int) (a * Math.pow(10, length) + b);
            int FenMu = (int) Math.pow(10, length);
            int MaxYueShu = getGongYueShu(FenZi, FenMu);
            result += FenZi / MaxYueShu + "/" + FenMu / MaxYueShu;
        }
        return result;
    }

}

@FunctionRecorder
public class StringCat extends AbstractFunction {

    @Override
    @ExecuteFunctionRecord
    public Object run(Object[] args) {
        String result = "fr:fr:";
        Object para;
        for (int i = 0; i < args.length; i++) {
            result+=args[i].toString();
        }
        return result;
    }

}
