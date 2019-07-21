/*
 * This file is part of Spa.
 *
 * Copyright (C) 2019
 * Caprica Software Limited (capricasoftware.co.uk)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.co.caprica.spasca

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import io.javalin.Javalin
import io.javalin.plugin.json.JavalinJackson
import uk.co.caprica.spasca.controller.{UserController, VersionController}

object Application {

    def main(args: Array[String]): Unit = {
        // Explicit configuration of a Jackson ObjectMapper is required to enable JSON marshalling for Scala classes
        val objectMapper = new ObjectMapper()
        objectMapper.registerModule(DefaultScalaModule)
        JavalinJackson.configure(objectMapper)

        val app = Javalin.create
            .get("/api/users", UserController.users)
            .get("/api/users/:username", UserController.user)
            .get("/api/*", (ctx) => ctx.status(400))           // Any unmapped API will result in a 400 Bad Request
            .get("version", VersionController.version)

        app.config
            .addStaticFiles("/app")                            // The ReactJS application
            .addStaticFiles("/")                               // Other static assets, external to the ReactJS application
            .addSinglePageRoot("/", "/app/index.html")       // Catch-all route for the single-page application

        app.start(8080)
    }

}
