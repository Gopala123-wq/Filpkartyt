import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class GopalaDevOps {

    public static void main(String[] args) throws IOException {

        // Create server on port 8080
        HttpServer server = HttpServer.create(
                new InetSocketAddress(8080), 0
        );

        // Handle browser requests
        server.createContext("/", GopalaDevOps::handleRequest);

        // Start server
        server.start();

        System.out.println("Gopala DevOps Application Started");
        System.out.println("Open: http://localhost:8080");
    }

    private static void handleRequest(HttpExchange exchange)
            throws IOException {

        String html = """
                <!DOCTYPE html>
                <html>
                <head>
                    <title>Gopala DevOps</title>

                    <style>
                        body {
                            font-family: Arial, sans-serif;
                            text-align: center;
                            background: #f2f4f7;
                            margin: 0;
                        }

                        header {
                            background: #1f2937;
                            color: white;
                            padding: 30px;
                        }

                        .container {
                            margin: 50px auto;
                            background: white;
                            padding: 40px;
                            width: 500px;
                            border-radius: 10px;
                            box-shadow: 0 4px 10px #ccc;
                        }

                        button {
                            padding: 12px 25px;
                            background: #2563eb;
                            color: white;
                            border: none;
                            border-radius: 5px;
                            cursor: pointer;
                        }

                        button:hover {
                            background: #1d4ed8;
                        }

                        footer {
                            margin-top: 50px;
                            background: #1f2937;
                            color: white;
                            padding: 20px;
                        }
                    </style>
                </head>

                <body>

                    <header>
                        <h1>Gopala DevOps 🚀</h1>
                        <p>Java Web Application</p>
                    </header>

                    <div class="container">

                        <h2>Welcome to DevOps</h2>

                        <p>
                            This application is created using Java.
                        </p>

                        <p>
                            Learning Linux, Git, AWS, Docker,
                            Jenkins and Kubernetes.
                        </p>

                        <button onclick="showMessage()">
                            Check Application
                        </button>

                        <h3 id="message"></h3>

                    </div>

                    <footer>
                        <p>© 2026 Gopala Krishna</p>
                    </footer>

                    <script>
                        function showMessage() {
                            document.getElementById("message").innerHTML =
                                "Application is running successfully 🚀";
                        }
                    </script>

                </body>
                </html>
                """;

        // Send response to browser
        exchange.getResponseHeaders()
                .set("Content-Type", "text/html");

        exchange.sendResponseHeaders(
                200,
                html.getBytes().length
        );

        OutputStream output = exchange.getResponseBody();

        output.write(html.getBytes());

        output.close();
    }
}

