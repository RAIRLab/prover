package com.naveensundarg.shadow.prover.utils;

import com.naveensundarg.shadow.prover.representations.value.Value;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by naveensundarg on 4/10/16.
 */
public class CollectionUtils {

    public static <T> List<T> newEmptyList(){
        return new ArrayList<>();
    }

    public static <T> Set<T> newEmptySet(){
        return new HashSet<>();
    }

    public static <T> List<T> listOf(T a){
        List<T> list = newEmptyList();
        list.add(a);
        return list;
    }

    public static <T> List<T> listOf(T... A){
        List<T> list = newEmptyList();
        for (T a:A){
            list.add(a);
        }

        return list;
    }
    public static <T> List<T> addToList(List<T> list, T a){
        List<T> newlist = newEmptyList();
        newlist.addAll(list);
        newlist.add(a);
        return newlist;
    }

    public static <T> Set<T> addToSet(Set<T> set, T a){
        Set<T> newSet = newEmptySet();
        newSet.addAll(set);
        newSet.add(a);
        return newSet;
    }



    public static <U,V> Map<U,V> newMap(){
        return new HashMap<>();
    }

    public static <T> List<T> add(List<T> list, T a){
        List<T> newList = newEmptyList();
        newList.addAll(list);
        newList.add(a);
        return newList;
    }

    public static <T> Set<T> union(Set<T> x, Set<T> y){

        Set<T> result = newEmptySet();

        result.addAll(x);
        result.addAll(y);
        return result;
    }

    public static <T> Set<T> setFrom(Set<T> set){
        return new HashSet<>(set);
    }

    public static <T>  boolean contains(T[] array, T value){
        return Arrays.stream(array).anyMatch(x->x.equals(value));
    }
    public static   List<Integer> matchingIndices(Value[] array, Value value){

        List<Integer> positions = CollectionUtils.newEmptyList();

        for(int i = 0;  i < array.length; i++){

            if(array[i].subValues().contains(value)){
                positions.add(i);
            }
        }

        return positions;
    }

    public static <T>  Set<T> fetchAtIndices(T[] array, List<Integer> positions){

        return positions.stream().map(position -> array[position]).collect(Collectors.toSet());


    }
}
