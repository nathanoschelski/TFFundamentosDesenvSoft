<<<<<<< HEAD
package interfaces;

import casosdeuso.*;
import entidades.*;

=======
package com.sales.interfaces;
>>>>>>> 7efa8ec7b80232b5166ef7a1a679a3d5d7e98abf

    public class ProdutoDAOException extends Exception {

        /**
         * Creates a new instance of
         * <code>ProdutoDAOException</code> without detail message.
         */
        public ProdutoDAOException() {
        }
    
        /**
         * Constructs an instance of
         * <code>ProdutoDAOException</code> with the specified detail message.
         *
         * @param msg the detail message.
         */
        public ProdutoDAOException(String msg) {
            super(msg);
        }
    
        public ProdutoDAOException(String message, Throwable cause) {
            super(message, cause);
        }
        
        
    }


