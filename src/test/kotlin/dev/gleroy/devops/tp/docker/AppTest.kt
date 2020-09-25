package dev.gleroy.devops.tp.docker

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.kotlintest.matchers.types.shouldNotBeNull
import io.kotlintest.shouldBe
import io.ktor.application.Application
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import org.junit.jupiter.api.Test
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication

class AppTest {
    val mapper = ObjectMapper().findAndRegisterModules()

    @Test
    const { Client } = require('pg');

    const pgclient = new Client({
        host: process.env.POSTGRES_HOST,
        port: process.env.POSTGRES_PORT,
        user: 'postgres',
        password: 'postgres',
        database: 'postgres'
    });

    pgclient.connect();

    const table = 'CREATE TABLE student(id SERIAL PRIMARY KEY, firstName VARCHAR(40) NOT NULL, lastName VARCHAR(40) NOT NULL, age INT, address VARCHAR(80), email VARCHAR(40))'
    const text = 'INSERT INTO student(firstname, lastname, age, address, email) VALUES($1, $2, $3, $4, $5) RETURNING *'
    const values = ['Mona the', 'Octocat', 9, '88 Colin P Kelly Jr St, San Francisco, CA 94107, United States', 'octocat@github.com']

    pgclient.query(table, (err, res) => {
        if (err) throw err
    });

    pgclient.query(text, values, (err, res) => {
        if (err) throw err
    });

    pgclient.query('SELECT * FROM student', (err, res) => {
        if (err) throw err
        console.log(err, res.rows) // Print the data in student table
        pgclient.end()
    });
    fun up() = withTestApplication(Application::module) {
        with(handleRequest(HttpMethod.Get, "/")) {
            response.status() shouldBe HttpStatusCode.OK
            response.content.shouldNotBeNull()
            mapper.readValue<StatusDto>(response.content!!) shouldBe StatusDto("up")
        }
    }
}
