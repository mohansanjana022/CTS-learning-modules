//com.utils

  module com.utils {
    exports com.utils;
}

//StringUtils.java
  
package com.utils;

public class StringUtils {
    public static String greet(String name) {
        return "Hello, " + name + "!";
    }
}

//com.greetings
module com.greetings {
    requires com.utils;
}

//Greeting.java
package com.greetings;

import com.utils.StringUtils;

public class Greeting {
    public static void main(String[] args) {
        String message = StringUtils.greet("this is the statement");
        System.out.println(message);
    }
}
//output
javac -d com.greetings/out --module-path com.utils/out --module-source-path com.greetings/src $(find com.greetings/src -name "*.java")
this is the statement
  

