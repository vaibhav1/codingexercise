package com.vaibhav1.codingexercise;

import java.util.HashMap;
import java.util.Map;

public class RobotCircularMove {

    public boolean judgeCircle(String moves) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for(char c: moves.toCharArray()){

            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            } else{
                map.put(c, 1);
            }
        }
        System.out.println("total L:"+map.get('L'));
        System.out.println("total R:"+map.get('R'));
        System.out.println("total U:"+map.get('U'));
        System.out.println("total D:"+map.get('D'));


        if(map.get('L').intValue() == map.get('R').intValue() && map.get('U').intValue() == map.get('D').intValue()){
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
        String s = "RULDDLLDLRDUUUURULRURRRRL" +
                "RULRLULLLRRULULDDRDLRULDRRULLUDDURD" +
                "LRRUDRUDDURLLLUUDULRUDRLURRDRLLDDLLLDLRLLRUUDUURDRLDUDRUDRLUDU" +
                "LRLUDRLDDUULDDLDURULUDUUDDRRDUURRLRDLDLRLLDRRUUURDLULLURRRRDRRURDUURDLRR" +
                "UULRURRUULULUUDURUDLRDDDDDURRRLRUDRUULUUUULDURDRULLRRRUDDDUUULUURRDRDDRLL" +
                "DRLDULDLUUDRDLULLDLDDRUUUUDDRRRDLLLLURUURLRUUULRDDULUULUURDURDDDRRURLURDL" +
                "LLRLULRDLDDLRDRRRRLUURRRRLDUDLLRUDLDRDLDRUULDRDULRULRRDLDLLLUDLDLULLDURUURR" +
                "LLULUURLRLRDUDULLDURRUDDLDDLLUDURLLRLDLDUDLURLLDRRURRDUDLDUULDUDRRUDULLUUDURRRURL" +
                "ULDDLRRURULUURURRDULUULDDDUUDRLDDRLULDUDDLLLDLDURDLRLUURDDRLUDRLUDLRRLUUULLDUUDUDU" +
                "RRUULLDDUDLURRDDLURLDRDRUDRLDDLDULDRULUDRRDRLLUURULURRRUDRLLUURULURRLUULRDDDRDDLDRLDR" +
                "LDUDRLDRLDDLDUDDURUDUDDDLRRDLUUUDUDURLRDRURUDUDDRDRRLUDURULDULDDRLDLUURUULUDRLRLRLLLLRLDRUR" +
                "RRUULRDURDRRDDURULLRDUDRLULRRLLLDRLRLRRDULDDUDUURLRULUUUULURULDLDRDRLDDLRLURRUULRRLDULLUULU" +
                "DUDRLDUDRDLLDULURLUDDUURULDURRUURLRDRRRLDDULLLLDDRRLRRDRDLRUDUUDLRLDRDRURULDLULRRDLLURDLLDLRDR" +
                "URLRUDURDRRRULURDRURLDRRRDUDUDUDURUUUUULURDUDDRRDULRDDLULRDRULDRUURRURLUDDDDLDRLDLLLLRLDRLRDRR" +
                "RLLDRDRUULURLDRULLDRRDUUDLURLLDULDUUDLRRRDDUDRLDULRDLLULRRUURRRURLRRLDDUDDLULRUDULDULRDUDRLRDUL" +
                "RUUDDRUURUDLDRDUDDUULLUDDLLRLURURLRRULLDDDLURDRRDLLLLULLDLUDDLURLLDDRLDLLDDRDRDDUDLDURLUUUUUDLL" +
                "LRLDULDDRDDDDRUDLULDRRLLLDUUUDDDRDDLLULUULRRULRUDRURDDULURDRRURUULDDDDUULLLURRRRDLDDLRLDDDRLUUDR" +
                "DDRDDLUDLUUULLDLRDLURRRLRDRLURUURLULLLLRDDLLLLRUDURRLDURULURULDDRULUDRLDRLLURURRRDURURDRRUDLDDLLRRDRDD" +
                "LRLRLUDUDRRUDLLDUURUURRDUDLRRLRURUDURDLRRULLDLLUDURUDDRUDULLDUDRRDDUDLLLDLRDRUURLLDLDRDDLDLLUDRDDRUUUDDULRUULRDRUDUURRRURUDLURLRDDLUUL" +
                "RDULRDURLLRDDDRRUDDUDUDLLDDRRUUDURDLLUURDLRULULDULRUUR" +
                "UDRULDRDULLULRRDDLDRDLLLDULRRDDLDRDLLRDDRLUUULUURULRULRUDULRULRUURUDUUDLDUDUUURLLURDDDUDUDLRLULDLDUDUU" +
                "LULLRDUDLDRUDRUULRURDDLDDRDULRLRLRRRRLRULDLLLDDRLUDLULLUUDLDRRLUDULRDRLLRRRULRLRLLUDRUUDUDDLRLDRDDDDRDLDRURULULRUURLRDLLDDRLL" +
                "RUDRRDDRDUDULRUDULURRUDRDLRDUUDDLDRUDLLDDLRLULLLRUUDRRRRUULLRLLULURLDUDDURLRULULDLDRURDRLLURRDLURRURLULDLRLDUDLULLLDRDLULDLRULLLU" +
                "DUDUDUDLDDDDDRDLUDUULLUDRLUURDRLULD";

        RobotCircularMove move = new RobotCircularMove();
        System.out.println("answer is: "+ move.judgeCircle(s));
    }
}
