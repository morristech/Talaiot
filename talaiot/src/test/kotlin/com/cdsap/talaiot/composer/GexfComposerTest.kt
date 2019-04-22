package com.cdsap.talaiot.composer

import com.cdsap.talaiot.composer.resources.ResourcesGexf
import com.cdsap.talaiot.composer.resources.ResourcesHtml
import com.cdsap.talaiot.entities.TaskLength
import com.cdsap.talaiot.entities.TaskMeasurementAggregated
import com.cdsap.talaiot.entities.TaskMessageState
import com.cdsap.talaiot.logger.LogTracker
import com.cdsap.talaiot.publisher.TestExecutor
import com.cdsap.talaiot.writer.FileWriter
import com.nhaarman.mockitokotlin2.argThat
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import io.kotlintest.specs.BehaviorSpec
import java.lang.StringBuilder

class GexfComposerTest : BehaviorSpec({
    given("Gexf Composer") {
        `when`("composing new aggregation ") {
            val logger: LogTracker = mock()
            val fileWriter: FileWriter<String> = mock()
            val executor = TestExecutor()
            val gexfComposer = GexfComposer(logger, fileWriter, executor)
            then("writer is using the content") {

                val content = "<node id=\"0\" label=\"assemble\">\n" +
                        "           <attvalues>\n" +
                        "                    <attvalue for=\"0\" value=\"app\"/>\n" +
                        "                    <attvalue for=\"1\" value=\"false\"/>\n" +
                        "           </attvalues>\n" +
                        "</node>\n" +
                        "<node id=\"1\" label=\"compileKotlin\">\n" +
                        "           <attvalues>\n" +
                        "                    <attvalue for=\"0\" value=\"app\"/>\n" +
                        "                    <attvalue for=\"1\" value=\"false\"/>\n" +
                        "           </attvalues>\n" +
                        "</node>\n" +
                        "<edge id=\"0\" source=\"1\" target=\"0\" />\n"

                gexfComposer.compose(taskMeasurementAggregated())
                verify(fileWriter).prepareFile(
                    argThat {
                        this == StringBuilder().apply {
                            append(ResourcesGexf.HEADER)
                            append(content)
                            append(ResourcesGexf.FOOTER)
                        }.toString()
                    }, argThat {
                        this == "gexfTaskDependency.gexf"
                    }
                )
            }
        }
    }
}
)

private fun taskMeasurementAggregated(): TaskMeasurementAggregated {
    return TaskMeasurementAggregated(
        emptyMap(),
        listOf(
            TaskLength(
                1,
                "assemble",
                "assemble",
                TaskMessageState.EXECUTED,
                true,
                "app",
                emptyList()
            ),
            TaskLength(
                2,
                "compileKotlin",
                "compileKotlin",
                TaskMessageState.EXECUTED,
                false,
                "app",
                listOf("assemble")

            )
        )
    )
}