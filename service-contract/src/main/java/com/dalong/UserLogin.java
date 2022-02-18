package com.dalong;

import org.pf4j.ExtensionPoint;

/**
 * @author  dalongrong
 */
public interface UserLogin extends ExtensionPoint {
    String token(String name,String password);
}
