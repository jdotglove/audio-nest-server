package src.main.java.nest.lib.helpers;

public enum HttpStatusCode {
    OK(200),
    CREATED(201),
    NOT_FOUND(404),
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    INTERNAL_SERVER_ERROR(500);

    // store the code
    private final int code;

    // constructor assigns it
    HttpStatusCode(int code) {
        this.code = code;
    }

    // expose it
    public int getCode() {
        return code;
    }
}
