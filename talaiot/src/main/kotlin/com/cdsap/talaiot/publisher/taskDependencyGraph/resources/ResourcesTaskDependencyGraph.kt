package com.cdsap.talaiot.publisher.taskDependencyGraph.resources

object ResourcesTaskDependencyGraph {
    const val HEADER = "<!doctype html>\n" +
            "<html>\n" +
            "<head>\n" +
            "  <title>Talaiot</title>\n" +
            "  <script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/vis/4.21.0/vis.min.js\"></script>\n" +
            "  <link href=\"https://cdnjs.cloudflare.com/ajax/libs/vis/4.21.0/vis.min.css\" rel=\"stylesheet\" type=\"text/css\" />\n" +
            "  <style type=\"text/css\">\n" +
            "    #mynetwork {\n" +
            "      width: 100%;\n" +
            "      height: 1000px;\n" +
            "      solid lightgray;\n" +
            "    }\n" +
            "  </style>\n" +
            "</head>\n" +
            "\n" +
            "<body onload=\"draw();\">\n" +
            "  <div id=\"mynetwork\"></div>\n" +
            "\n" +
            "  <script type=\"text/javascript\">\n" +
            "    var network = null;\n" +
            "    var layoutMethod = \"directed\";\n" +
            "\n" +
            "    function destroy() {\n" +
            "      if (network !== null) {\n" +
            "        network.destroy();\n" +
            "        network = null;\n" +
            "      }\n" +
            "    }\n" +
            "\n" +
            "    function draw() {\n" +
            "      destroy();\n" +
            "      var nodes = [];\n" +
            "      var edges = [];"
    const val FOOTER = "      var container = document.getElementById('mynetwork');\n" +
            "      var data = {\n" +
            "        nodes: nodes,\n" +
            "        edges: edges\n" +
            "      };\n" +
            "\n" +
            "      var options = {\n" +
            "        physics: {\n" +
            "          enabled: false\n" +
            "        },\n" +
            "        layout: {\n" +
            "          improvedLayout: true,\n" +
            "          hierarchical: {\n" +
            "            enabled: true,\n" +
            "            levelSeparation: 200,\n" +
            "            nodeSpacing: 600,\n" +
            "            treeSpacing: 200,\n" +
            "            blockShifting: true,\n" +
            "            edgeMinimization: false,\n" +
            "            parentCentralization: true,\n" +
            "            direction: 'LR', // UD, DU, LR, RL\n" +
            "            sortMethod: 'hubsize' // hubsize, directed\n" +
            "          }\n" +
            "        },\n" +
            "        nodes: {\n" +
            "          shape: 'dot',\n" +
            "          margin: 10,\n" +
            "          color: {\n" +
            "            border: '#2B7CE9',\n" +
            "            background: '#97C2FC',\n" +
            "            highlight: {\n" +
            "              border: '#cc4CE9',\n" +
            "              background: '#D2E5FF'\n" +
            "            },\n" +
            "            hover: {\n" +
            "              border: '#2B7CE9',\n" +
            "              background: '#D2E5FF'\n" +
            "            }\n" +
            "          },\n" +
            "\n" +
            "        },\n" +
            "        edges: {\n" +
            "          smooth: true,\n" +
            "          arrows: {\n" +
            "            from: true\n" +
            "          },\n" +
            "          color: {\n" +
            "            color: '#848484',\n" +
            "            highlight: '#cc2233',\n" +
            "            hover: '#848484',\n" +
            "            inherit: 'from',\n" +
            "            opacity: 1.0\n" +
            "          },\n" +
            "        }\n" +
            "      };\n" +
            "      network = new vis.Network(container, data, options);\n" +
            "    }\n" +
            "</script>\n"
}