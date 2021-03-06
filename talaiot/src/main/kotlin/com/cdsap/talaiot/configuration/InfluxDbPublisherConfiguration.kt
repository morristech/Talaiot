package com.cdsap.talaiot.configuration

import groovy.lang.Closure

/**
 * Configuration for the InfluxDbPublisher. It belongs to the Publisher configurations
 *
 * influxDbPublisher {
 *    dbName = "tracking"
 *    url = "url"
 *    urlMetric = "tracking
 *
 *    filter{
 *      tasks{
 *          includes = arrayOf("cle.*")
 *          excludes = arrayOf("taskA")
 *       }
 *      modules{
 *          includes = arrayOf("feature.*")
 *          excludes = arrayOf("utils.*")
 *       }
 *     }
 * }
 */
class InfluxDbPublisherConfiguration : PublisherConfiguration {
    /**
     * name of the publisher
     */
    override var name: String = "influxDb"
    /**
     * name of the InfluxDb database, it should be created before the first tracking
     */
    var dbName: String = ""
    /**
     * url from the InfluxDb instance required to send the measurements. For instance http://localhost:8086
     */
    var url: String = ""
    /**
     * metric to identify the measurement in InfluxDb
     */
    var urlMetric: String = ""
    var threshold: ThresholdConfiguration? = null

    var filter: FilterConfiguration? = null

    fun threshold(configuration: ThresholdConfiguration.() -> Unit) {
        threshold = ThresholdConfiguration().also(configuration)
    }

    fun threshold(closure: Closure<*>) {
        threshold = ThresholdConfiguration()
        closure.delegate = threshold
        closure.call()
    }


    fun filter(configuration: FilterConfiguration.() -> Unit) {
        filter = FilterConfiguration().also(configuration)
    }

    fun filter(closure: Closure<*>) {
        filter = FilterConfiguration()
        closure.delegate = filter
        closure.call()
    }
}
