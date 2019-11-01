package com.example.make_a_thon.network.client;

import com.example.make_a_thon.base_java.BaseClientJava;
import com.example.make_a_thon.database.sharedpreference.Token;
import com.example.make_a_thon.network.api.ReportApiJava;
import com.example.make_a_thon.network.request.ReportRequest;

import io.reactivex.Single;
import retrofit2.Response;

public class ReportClientJava extends BaseClientJava<ReportApiJava> {

    @Override
    protected Class api() {

        return ReportApiJava.class;
    }

    public Single<String> report(Token token, ReportRequest reportRequest) {

        return api.report(token.getToken(), reportRequest).map(Response::message);
    }
}
