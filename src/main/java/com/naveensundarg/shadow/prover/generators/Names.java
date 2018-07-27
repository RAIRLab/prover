package com.naveensundarg.shadow.prover.generators;

import com.naveensundarg.shadow.prover.utils.CollectionUtils;

import java.util.Map;

public class Names {

    //TODO: Read these from a config file.

    public static final String[] NAMES= {"a", "b", "c", "d", "e"};

    public static final String[] CONSTANTS= {"jack", "john", "mary", "jill", "alice", "bob"};

    public static final String[] UNARY_RELATIONS= {"Student", "Good", "Bad", "Happy", "Sad"};
    public static final String[] BINARY_RELATIONS= {"Killed", "Saw", "Asked", "Advised", "Promised"};

    public static final String[] UNARY_FUNCTIONS = {"parentOf", "grandParentOf"};
    public static final String[] VARIABLES = {"?p1", "?q1", "?r1", "?s1", "?t1", "?x1", "?y1", "?z1",
            "?p2", "?q2", "?r2", "?s2", "?t2", "?x2", "?y2", "?z2"};

    private static final Map<String,Integer> NAME_TO_INT = CollectionUtils.newMap();


    static {

        NAME_TO_INT.put("a", 1);
        NAME_TO_INT.put("b", 1);
        NAME_TO_INT.put("c", 1);
        NAME_TO_INT.put("d", 1);
        NAME_TO_INT.put("e", 1);

    }
}
