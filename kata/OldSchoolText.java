package kata;

import java.util.Hashtable;

public class OldSchoolText {
  static Hashtable<Character, String> mappings;

  public static void setMappings() {
    mappings = new Hashtable<Character, String>();
    mappings.put('1', "1-");
    mappings.put('.', "1");
    mappings.put(',', "11");
    mappings.put('?', "111");
    mappings.put('!', "1111");

    mappings.put('2', "2-");
    mappings.put('a', "2");
    mappings.put('b', "22");
    mappings.put('c', "222");

    mappings.put('3', "3-");
    mappings.put('d', "3");
    mappings.put('e', "33");
    mappings.put('f', "333");

    mappings.put('4', "4-");
    mappings.put('g', "4");
    mappings.put('h', "44");
    mappings.put('i', "444");

    mappings.put('5', "5-");
    mappings.put('j', "5");
    mappings.put('k', "55");
    mappings.put('l', "555");

    mappings.put('6', "6-");
    mappings.put('m', "6");
    mappings.put('n', "66");
    mappings.put('o', "666");

    mappings.put('7', "7-");
    mappings.put('p', "7");
    mappings.put('q', "77");
    mappings.put('r', "777");
    mappings.put('s', "7777");

    mappings.put('8', "8-");
    mappings.put('t', "8");
    mappings.put('u', "88");
    mappings.put('v', "888");

    mappings.put('9', "9-");
    mappings.put('w', "9");
    mappings.put('x', "99");
    mappings.put('y', "999");
    mappings.put('z', "9999");

    mappings.put('*', "*-");
    mappings.put('\'', "*");
    mappings.put('-', "**");
    mappings.put('+', "***");
    mappings.put('=', "****");

    mappings.put('0', "0-");
    mappings.put(' ', "0");

    mappings.put('#', "#-");

    mappings.put('_', " ");

    mappings.put('$', "#");
  }

  public static String getKeystrokes(String message) {
    Boolean usingLowerCase = true;
    String adjustedMessage = "";
    for(int i = 0; i < message.length(); i++) {
      Character charI = message.charAt(i);
      String adjusted = String.valueOf(Character.toLowerCase(charI));
      Boolean changingCase = (usingLowerCase && Character.isUpperCase(charI)) || (!usingLowerCase && Character.isLowerCase(charI));
      if(changingCase) {
        adjusted = "$" + adjusted;
        usingLowerCase = !usingLowerCase;
      } else if(i > 0) {
        String mappingI = mappings.get(Character.toLowerCase(charI));
        String mappingPrev = mappings.get(Character.toLowerCase(message.charAt(i-1)));
        Boolean mappingPrevEndsWithHyphen = mappingPrev.charAt(mappingPrev.length() - 1) == '-';
        if(!mappingPrevEndsWithHyphen && mappingI.charAt(0) == mappingPrev.charAt(0)) {
          adjusted = "_" + adjusted;
        }
      }
      adjustedMessage += adjusted;
    }

    String keystrokes = "";
    for(int i = 0; i < adjustedMessage.length(); i++) {
      keystrokes += mappings.get(adjustedMessage.charAt(i));
    }
    return keystrokes;
  }

  public static String sendMessage(String message) {
    setMappings();
    return getKeystrokes(message);
  }
}