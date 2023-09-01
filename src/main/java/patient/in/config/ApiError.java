package patient.in.config;

public class ApiError {

        private String statusCode;
        private String errorMsg;

        public ApiError(String statusCode, String errorMsg) {
            this.statusCode = statusCode;
            this.errorMsg = errorMsg;
        }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
