package Stream;

enum Operation {

    ADD {
        @Override
        int apply(int a, int b) {
            return a + b;
        }
    },

    SUBTRACT {
        @Override
        int apply(int a, int b) {
            return a - b;
        }
    },

    MULTIPLY {
        @Override
        int apply(int a, int b) {
            return a * b;
        }
    };

    // abstract method
    abstract int apply(int a, int b);
}

enum ErrorCode {
    INVALID_REQUEST(400),
    UNAUTHORIZED(401),
    NOT_FOUND(404),
    INTERNAL_ERROR(500);

    private final int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}



public class enumClassExample {
    public static void main(String[] args) {
        System.out.println(Operation.ADD.apply(10, 5));       // 15
        System.out.println(Operation.SUBTRACT.apply(10, 5));  // 5
        System.out.println(Operation.MULTIPLY.apply(10, 5));  // 50
    }
}
