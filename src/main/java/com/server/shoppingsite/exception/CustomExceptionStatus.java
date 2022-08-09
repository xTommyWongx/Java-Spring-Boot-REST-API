package com.server.shoppingsite.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CustomExceptionStatus {
    /**
     * 1000 :
     */
    SUCCESS(true, 1000, "The request was successful."),


    /**
     * 2000 : Request
     */
    // Common
    REQUEST_ERROR(false, 2000, "Please check input value."),
    EMPTY_JWT(false, 2001, "Please submit JWT."),
    INVALID_JWT(false, 2002, "Invalid JWT."),
    INVALID_USER_JWT(false,2003,"Unauthorized JWT requests."),
    NOT_AUTHENTICATED_ACCOUNT(false, 2004, "Login is required."),

    // users
    USERS_EMPTY_USER_ID(false, 2010, "Please check the user ID value."),
    ACCOUNT_NOT_FOUND(false, 2011, "User not found."),
    ACCOUNT_NOT_VALID(false, 2012, "Not a valid user."),
    ACCOUNT_NOT_VALID_ROLE(false, 2013, "Not a valid Role type."),

    // [POST] /users
    POST_USERS_EMPTY_EMAIL(false, 2020, "Please enter your e-mail."),
    POST_USERS_INVALID_EMAIL(false, 2021, "Please check your email format."),
    POST_USERS_EXISTS_EMAIL(false,2022,"This is a duplicate email."),
    POST_USERS_EMPTY_NICKNAME(false, 2023, "Please enter your nickname."),
    POST_USERS_INVALID_NICKNAME(false, 2024, "Please check the nickname format."),
    POST_USERS_EXISTS_NICKNAME(false,2025,"Duplicate nickname."),
    POST_USERS_INVALID_PASSWORD(false, 2026, "Please check the password format."),
    POST_USERS_EMPTY_PASSWORD(false, 2027, "Please enter a password"),
    POST_USERS_EMPTY_ID(false, 2028, "Please enter your ID."),
    POST_USERS_INVALID_ID(false, 2029, "Please check the ID format."),
    POST_USERS_EXISTS_ID(false,2030,"Duplicate ID."),
    POST_USERS_EMPTY_ADDRESS(false, 2031, "Please enter your address."),
    POST_USERS_INVALID_ADDRESS(false, 2032, "Please check the address format."),
    POST_USERS_EMPTY_BIRTH_OF_DATE(false, 2033, "Please enter your birth date."),
    POST_USERS_INVALID_DATE(false, 2034, "Please check the year-month-day format."),

    // Product
    PRODUCT_NOT_FOUND(false, 2040, "Can not find a product."),
    PRODUCT_COST_NOT_CORRECT(false, 2041, "Cost of product is not correct."),

    // Options
    OPTIONS_NOT_FOUND(false, 2050, "Option not found."),

    // Store
    STORE_NOT_FOUND(false, 2060, "Store not found."),

    // Category
    CATEGORY_NOT_FOUND(false, 2070, "Category not found."),

    // Supplier
    SUPPLIER_NOT_FOUND(false, 2080, "Supplier not found."),

    // Role
    ACCOUNT_ACCESS_DENIED(false, 2090, "You do not have permission."),

    /**
     * 3000 : Response
     */
    // Common
    RESPONSE_ERROR(false, 3000, "Failed to load value."),

    // [POST] /users
    DUPLICATED_EMAIL(false, 3010, "This is a duplicate email."),
    DUPLICATED_NICKNAME(false, 3011, "Duplicate nickname."),
    DUPLICATED_NICKNAME_SELF(false, 3012, "Duplicate with original nickname."),
    FAILED_TO_LOGIN(false,3013,"ID does not exist or password is incorrect."),
    ALREADY_CERTIFICATION_ACCOUNT(false,3014,"You are already an authenticated user."),
    FAILED_TO_CERTIFICATION(false,3015,"Not a valid token value."),
    FAILED_TO_RECEPTION(false,3016,"Not a valid incoming number."),
    DUPLICATED_ID(false, 3017, "Duplicate ID."),

    // Location
    LOCATION_NOT_VALID(false,3030,"Not a valid address."),
    LOCATION_NOT_FOUND(false, 3060, "Not a valid address."),

    // Store
    ALREADY_CREATED_STORE(false,3040,"Store already exists."),

    // City
    CITY_NOT_FOUND(false, 3050, "City not found."),

    // APPLICANT
    APPLICANT_ALREADY_EXIST(false, 3060, "Application already existing."),


    /**
     * 4000 : Database, Server
     */
    DATABASE_ERROR(false, 4000, "Failed to connect to database."),
    SERVER_ERROR(false, 4001, "Failed to connect to server."),

    //[PATCH] /users/{userIdx}
    MODIFY_FAIL_USERNAME(false,4010,"Failed to edit username"),

    PASSWORD_ENCRYPTION_ERROR(false, 4020, "Password encryption failed."),
    PASSWORD_DECRYPTION_ERROR(false, 4021, "Password decryption failed.");


    // 5000

    // 6000


    private final boolean isSuccess;
    private final int code;
    private final String message;
}
