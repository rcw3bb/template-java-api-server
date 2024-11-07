package xyz.ronella.template.api.commons;

import lombok.Getter;

/**
 * Enum representing HTTP response statuses and their corresponding status codes.
 * Each constant in this enum represents a specific HTTP response status as defined
 * in the HTTP/1.1 and HTTP/2 specifications.
 *
 * Note: Enum names are abbreviated to be within 17 characters.
 *
 * @author Ron Webb
 * @since 1.0.0
 */
@Getter
public enum ResponseStatus {

    // 1xx Informational
    CONTINUE(100),
    SWITCHING_PROTO(101),
    PROCESSING(102),
    EARLY_HINTS(103),

    // 2xx Success
    OK(200),
    CREATED(201),
    ACCEPTED(202),
    NON_AUTH_INFO(203),
    NO_CONTENT(204),
    RESET_CONTENT(205),
    PARTIAL_CONTENT(206),
    MULTI_STATUS(207),
    ALREADY_REPORTED(208),
    IM_USED(226),

    // 3xx Redirection
    MULTI_CHOICES(300),
    MOVED_PERM(301),
    FOUND(302),
    SEE_OTHER(303),
    NOT_MODIFIED(304),
    USE_PROXY(305),
    TEMP_REDIRECT(307),
    PERM_REDIRECT(308),

    // 4xx Client Error
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    PAYMENT_REQ(402),
    FORBIDDEN(403),
    NOT_FOUND(404),
    METHOD_NOT_ALLOWD(405),
    NOT_ACCEPTABLE(406),
    PROXY_AUTH_REQ(407),
    REQ_TIMEOUT(408),
    CONFLICT(409),
    GONE(410),
    LENGTH_REQ(411),
    PRECOND_FAILED(412),
    PAYLOAD_TOO_LARGE(413),
    URI_TOO_LONG(414),
    UNSUPP_MEDIA_TYPE(415),
    RANGE_NOT_SAT(416),
    EXPECT_FAILED(417),
    MISDIR_REQ(421),
    UNPROC_ENTITY(422),
    LOCKED(423),
    FAILED_DEP(424),
    TOO_EARLY(425),
    UPGRADE_REQ(426),
    PRECOND_REQ(428),
    TOO_MANY_REQ(429),
    REQ_HDRS_TOO_LG(431),
    UNAVAIL_LEGAL(451),

    // 5xx Server Error
    INT_SERVER_ERR(500),
    NOT_IMPL(501),
    BAD_GATEWAY(502),
    SERVICE_UNAVAIL(503),
    GATEWAY_TIMEOUT(504),
    HTTP_VER_NOT_SUPP(505),
    VARIANT_NEG(506),
    INSUFF_STORAGE(507),
    LOOP_DETECTED(508),
    NOT_EXTENDED(510),
    NET_AUTH_REQ(511);

    private final int code;

    /**
     * Constructor to create a response status with a specific HTTP status code.
     *
     * @param code the HTTP status code for this response status.
     */
    ResponseStatus(final int code) {
        this.code = code;
    }

}