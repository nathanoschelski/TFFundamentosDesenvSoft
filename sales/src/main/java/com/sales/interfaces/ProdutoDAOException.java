



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


