package com.example.hshop.api.exception

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.util.stream.Collectors

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException::class)
    fun handleEntityNotFoundException(
        exception: EntityNotFoundException,
        request: HttpServletRequest
    ): ResponseEntity<ErrorResponse?> = createErrorResponse(
        HttpStatus.NOT_FOUND,
        exception.message ?: "Entity not found",
        request.requestURI
    )

    @ExceptionHandler(InvalidRequestException::class)
    fun handleInvalidRequestException(
        exception: InvalidRequestException,
        request: HttpServletRequest
    ): ResponseEntity<ErrorResponse?> = createErrorResponse(
        HttpStatus.BAD_REQUEST,
        exception.message ?: "Invalid request",
        request.requestURI
    )

    @ExceptionHandler(UnauthorizedException::class)
    fun handleUnauthorizedException(
        exception: UnauthorizedException,
        request: HttpServletRequest
    ): ResponseEntity<ErrorResponse?> = createErrorResponse(
        status = HttpStatus.UNAUTHORIZED,
        message = exception.message ?: "Unauthorized",
        path = request.requestURI
    )

    @ExceptionHandler(Exception::class)
    fun handleGenericException(
        exception: Exception,
        request: HttpServletRequest
    ): ResponseEntity<ErrorResponse?> = createErrorResponse(
        status = HttpStatus.INTERNAL_SERVER_ERROR,
        message = exception.message ?: "An unexpected error occurred",
        path = request.requestURI
    )

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(
        exception: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): ResponseEntity<ErrorResponse?> {
        val message = exception
            .bindingResult
            .fieldErrors
            .stream()
            .map<String?> { fieldError: FieldError? -> fieldError!!.field + ": " + fieldError.defaultMessage }
            .collect(Collectors.joining(", "))

        return createErrorResponse(
            status = HttpStatus.BAD_REQUEST,
            message = message,
            path = request.requestURI
        )
    }

    /*@ExceptionHandler(UsernameNotFoundException::class)
    fun handleUsernameNotFoundException(
        exception: UsernameNotFoundException,
        request: HttpServletRequest
    ): ResponseEntity<ErrorResponse?> {
        return createErrorResponse(
            HttpStatus.NOT_FOUND,
            if (exception.getMessage() != null) exception.getMessage() else "User not found",
            request.getRequestURI()
        )
    }*/

    fun createErrorResponse(
        status: HttpStatus,
        message: String,
        path: String
    ): ResponseEntity<ErrorResponse?> {
        val response = ErrorResponse(
            status = status.value(),
            error = status.reasonPhrase,
            message = message,
            path = path
        )
        return ResponseEntity.status(status).body<ErrorResponse?>(response)
    }
}