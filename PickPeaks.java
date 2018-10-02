/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pickpeaks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Joey
 */
public class PickPeaks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] peak_array = {3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 3};
        System.out.println(getPeaks(peak_array));
        
    }
    
    public static Map<String, List<Integer>> getPeaks(int[] arr) {
        Map<String, List<Integer>> values = new HashMap<>();
        List<Integer> position = new ArrayList<>();
        List<Integer> peak = new ArrayList<>();
        
        for(int i = 1; i < arr.length - 1; i++) {
            if(arr[i - 1] < arr[i]) {
                if(arr[i] > arr[i + 1]) {
                    position.add(i);
                    peak.add(arr[i]);
                } else if(arr[i] == arr[i + 1]) {
                    for(int j = i; j < arr.length - 1; j++) {
                        if(arr[j] == arr[j + 1]) {
                            continue;
                        }
                        if(arr[j] < arr[j + 1]) {
                            break;
                        }
                        if(arr[j] > arr[j + 1]) {
                            position.add(i);
                            peak.add(arr[i]);
                            break;
                        }
                    }
                }
            }
        }
        
        values.put("pos", position);
        values.put("peaks", peak);
        
        return values;
        
    }
    
}
