package cinema.handling;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    private class JsonResponse {

        private String error;
        int httpStatus;

        public JsonResponse() {

        }

        public JsonResponse(String error, int httpStatus) {
            this.error = error;
            this.httpStatus = httpStatus;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public int getHttpStatus() {
            return httpStatus;
        }

        public void setHttpStatus(int httpStatus) {
            this.httpStatus = httpStatus;
        }
    }

    @ExceptionHandler({SeatNotFoundException.class, SeatPurchasedException.class, TokenNotFoundException.class})
    @ResponseBody
    public ResponseEntity<JsonResponse> handleSeatNotFoundException(
            Exception ex, WebRequest request) {
        return new ResponseEntity<JsonResponse>(new JsonResponse(ex.getMessage(), 400), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PasswordValidationException.class)
    @ResponseBody
    public ResponseEntity<JsonResponse> handleIncorrectPasswordException(Exception ex, WebRequest request) {
        return new ResponseEntity<JsonResponse>(new JsonResponse(ex.getMessage(), 401), new HttpHeaders(), HttpStatus.UNAUTHORIZED);
    }

}
