package io.github.davidmerrick.knotion.model.properties

import com.google.i18n.phonenumbers.PhoneNumberUtil
import io.github.davidmerrick.knotion.model.properties.PropertyType.PhoneNumber

data class PhoneNumberProperty(
    override val id: String? = null,
    val phoneNumber: String? = null
) : NotionProperty {
    override val type = PhoneNumber

    val prettyPhoneNumber: String? by lazy {
        val phoneUtil = PhoneNumberUtil.getInstance()
        try {
            val number = phoneUtil.parse(phoneNumber, "US")
            if (phoneUtil.isValidNumber(number)) {
                val nationalNumber = number.nationalNumber.toString() // e.g., "9713405572"
                if (nationalNumber.length == 10) {
                    val area = nationalNumber.substring(0, 3)
                    val prefix = nationalNumber.substring(3, 6)
                    val line = nationalNumber.substring(6)
                    "$area-$prefix-$line"
                } else {
                    // Don't format if it's not a 10-digit US number
                    null
                }
            } else null
        } catch (_: Exception) {
            null
        }
    }
}
