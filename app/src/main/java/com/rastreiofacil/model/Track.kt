package com.rastreiofacil.model

import com.google.gson.JsonArray
import com.google.gson.JsonNull
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json    = Json(JsonConfiguration.Stable)
// val welcome = json.parse(Welcome.serializer(), jsonString)


data class Track (
    val meta: Meta,
    val data: Data
)


data class Data (
    val tracking: Tracking
)


data class Tracking (
    val id: String,

    @SerializedName("created_at")
    val createdAt: String,

    @SerializedName("updated_at")
    val updatedAt: String,

    @SerializedName("last_updated_at")
    val lastUpdatedAt: String,

    @SerializedName("tracking_number")
    val trackingNumber: String,

    val slug: String,
    val active: Boolean,
    val android: Array<String>,

//    @SerializedName("custom_fields")
//    val customFields: JsonObject? = null,

    @SerializedName("customer_name")
    val customerName: String? = null,

    @SerializedName("delivery_time")
    val deliveryTime: Long,

    @SerializedName("destination_country_iso3")
    val destinationCountryIso3: String? = null,

    @SerializedName("courier_destination_country_iso3")
    val courierDestinationCountryIso3: String? = null,

    val emails: List<String>,

    @SerializedName("expected_delivery")
    val expectedDelivery: String? = null,

    val ios: Array<String>,
    val note: String? = null,

    @SerializedName("order_id")
    val orderID: String,

    @SerializedName("order_id_path")
    val orderIDPath: String,

    @SerializedName("order_date")
    val orderDate: String? = null,

    @SerializedName("origin_country_iso3")
    val originCountryIso3: String,

    @SerializedName("shipment_package_count")
    val shipmentPackageCount: Int? = null,

    @SerializedName("shipment_pickup_date")
    val shipmentPickupDate: String,

    @SerializedName("shipment_delivery_date")
    val shipmentDeliveryDate: String,

    @SerializedName("shipment_type")
    val shipmentType: String? = null,

    @SerializedName("shipment_weight")
    val shipmentWeight: Int? = null,

    @SerializedName("shipment_weight_unit")
    val shipmentWeightUnit: String? = null,

    @SerializedName("signed_by")
    val signedBy: String? = null,

    val smses: List<String>,
    val source: String,
    val tag: String,
    val subtag: String,

    @SerializedName("subtag_message")
    val subtagMessage: String,

    val title: String,

    @SerializedName("tracked_count")
    val trackedCount: Long,

    @SerializedName("last_mile_tracking_supported")
    val lastMileTrackingSupported: Boolean,

    val language: String,

    @SerializedName("unique_token")
    val uniqueToken: String,

    val checkpoints: List<Checkpoint>,

    @SerializedName("subscribed_smses")
    val subscribedSmses: Array<String>,

    @SerializedName("subscribed_emails")
    val subscribedEmails: Array<String>,

    @SerializedName("return_to_sender")
    val returnToSender: Boolean,

    @SerializedName("order_promised_delivery_date")
    val orderPromisedDeliveryDate: String? = null,

    @SerializedName("delivery_type")
    val deliveryType: String,

    @SerializedName("pickup_location")
    val pickupLocation: String? = null,

    @SerializedName("pickup_note")
    val pickupNote: String? = null,

    @SerializedName("courier_tracking_link")
    val courierTrackingLink: String,

    @SerializedName("first_attempted_at")
    val firstAttemptedAt: String,

    @SerializedName("courier_redirect_link")
    val courierRedirectLink: String? = null,

    @SerializedName("tracking_account_number")
    val trackingAccountNumber: String? = null,

    @SerializedName("tracking_origin_country")
    val trackingOriginCountry: String? = null,

    @SerializedName("tracking_destination_country")
    val trackingDestinationCountry: String? = null,

    @SerializedName("tracking_key")
    val trackingKey: String? = null,

    @SerializedName("tracking_postal_code")
    val trackingPostalCode: String? = null,

    @SerializedName("tracking_ship_date")
    val trackingShipDate: String? = null,

    @SerializedName("tracking_state")
    val trackingState: String? = null
)


data class Checkpoint (
    val slug: String,
    val city: String,

    @SerializedName("created_at")
    val createdAt: String,

    val location: String,

    @SerializedName("country_name")
    val countryName: String? = null,

    val message: String,

    @SerializedName("country_iso3")
    val countryIso3: String? = null,

    val tag: String,
    val subtag: String,

    @SerializedName("subtag_message")
    val subtagMessage: String,

    @SerializedName("checkpoint_time")
    val checkpointTime: String,

    val coordinates: JsonArray,
    val state: String? = null,
    val zip: JsonNull? = null,

    @SerializedName("raw_tag")
    val rawTag: JsonNull? = null
)


data class Meta (
    val code: Long
)
