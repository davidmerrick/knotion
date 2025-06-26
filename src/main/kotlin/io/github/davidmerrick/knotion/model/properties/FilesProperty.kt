package io.github.davidmerrick.knotion.model.properties

import com.fasterxml.jackson.annotation.JsonInclude
import io.github.davidmerrick.knotion.model.properties.PropertyType.Files

@JsonInclude(JsonInclude.Include.NON_NULL)
data class FilesProperty(
    override val id: String? = null,
    val files: List<NotionFile>
) : NotionProperty {
    override val type = Files
}

/**
 *
 * "Photo" : {
 *         "id" : "jbv%3D",
 *         "type" : "files",
 *         "files" : [ {
 *           "name" : "nancy_merrick.png",
 *           "type" : "file",
 *           "file" : {
 *             "url" : "https://prod-files-secure.s3.us-west-2.amazonaws.com/d62c6d37-f94c-49ae-aae4-092ddc528824/323e865c-4395-4480-83b1-0b088ba1fc6b/nancy_merrick.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=ASIAZI2LB466XQ7XISVB%2F20250624%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20250624T214344Z&X-Amz-Expires=3600&X-Amz-Security-Token=IQoJb3JpZ2luX2VjEDwaCXVzLXdlc3QtMiJGMEQCIGR%2BjlfKW4qgjUJPBF1VJJo7tqTc7XB1Y1xI9YSByLeBAiB4nO7YkdAAbokUWgrULFVekvPewHGf2GGrzfNhYe%2FvXCr%2FAwg1EAAaDDYzNzQyMzE4MzgwNSIMhxsiNRvfFukYHP2AKtwD0Q9PysrS5vcSJ5c2H0uxCCAkQHuGafi3B1aXsBx6QCQG1Zw0xJcgystoh7tGBFNnZVVOgx4pra9%2FF0v5CGCzaX8yDvskIZyH%2Bh%2FZN02skDwF%2BsHH5Gp8l9Q6CiVXVdTKt%2Fvf%2FwTx3DICJ6%2B2vnMeeCM7u12n2YyMnlwFHrT7X7r7RMG8TG49F13aCWSq2ZgossXV6wsb982kPbVAWG3%2FXAHGzBGw7mXtKYe545wQZCznXXdD8z%2BW2TnItrurYAC%2BmDurxJGDtxNNVtyrvWRKXPdT9B9wq8xCB%2Bv%2BqJtpZC1bsRNxpyuvPM8ygeK7tZzJGjZ7CEFBCrKs7%2B55QMCiqNpqSOUz%2F%2BDrTaqlfoSsEz64H%2FOa%2FJANccKpU9c7HiNjkYr2GrastWXoac3Kto8hIU68W49C18Ou2ssJzS6qPO6pNhS36fduvk%2ByoWmgb8abn%2Bq%2Fxp9w3OYkL939gsNv1hakLYhNBh8sj7Jd32fDavwv3wSiyasQXlxrq%2B6U7GZN3UZSWdTktkiP29e6e%2B%2BIaFMvhMsMvyJltMfPluXoGMyxF%2F7vaFA5neUvcvUG%2BTAHoqONo1nfgDjIWNbB2YmSD5E%2Fxbh863fb6gg0Zi1BlMhOG0FO5qTTnAl38ccw1ovswgY6pgEitO8DhcLaixj9U4C9zqLDnmCo5ZrngWpR9RUuFB0dM%2BhR%2F50RUeXor7iQRhG4U1T8eYzXP4iPAWkWJQk7IJU2pTfUCdBfEI9UNg%2BIY9Za0AX6B05LmnxkRemlLSMmTUHHw9hwEvws%2BBkEDXYxvLBASmNAJXGFb9J3jMNNi0t1rqitNCYTWc%2FiJPqsAAlqkvuvQ%2F8SnPUbbT%2BmKb581zJx8u7OsMus&X-Amz-Signature=17757b2fda7d8f695f35b15dd2f9fcf47bf60c00532c27a46a203a8c5d59397e&X-Amz-SignedHeaders=host&x-amz-checksum-mode=ENABLED&x-id=GetObject",
 *             "expiry_time" : "2025-06-24T22:43:44.570Z"
 *           }
 *         } ]
 */
