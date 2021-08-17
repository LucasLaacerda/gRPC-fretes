package br.com.zup.edu

import io.micronaut.grpc.server.GrpcEmbeddedServer
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import javax.inject.Inject

@Controller
class GrpcStopServer(@Inject val serverGrpc: GrpcEmbeddedServer){

    //teste para verificar status no health check
    @Get("/server/stop")
    fun stopServer(): MutableHttpResponse<String>? {

        serverGrpc.stop()

        return HttpResponse.ok("is-running? ${serverGrpc.isRunning}")
    }

}