/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.sofa.tracer.plugins.springmvc;

import com.alipay.common.tracer.core.appender.builder.JsonStringBuilder;
import com.alipay.common.tracer.core.appender.self.Timestamp;
import com.alipay.common.tracer.core.context.span.SofaTracerSpanContext;
import com.alipay.common.tracer.core.middleware.parent.AbstractDigestSpanEncoder;
import com.alipay.common.tracer.core.span.CommonSpanTags;
import com.alipay.common.tracer.core.span.SofaTracerSpan;

import java.io.IOException;
import java.util.Map;

/**
 * SpringMvcDigestEncoder
 *
 * @author yangguanchao
 * @since 2018/05/14
 */
public class SpringMvcDigestJsonEncoder extends AbstractDigestSpanEncoder {

    @Override
    public String encode(SofaTracerSpan span) throws IOException {
        JsonStringBuilder jsonStringBuilder = new JsonStringBuilder();
        jsonStringBuilder.appendBegin(CommonSpanTags.TIME, Timestamp.format(span.getEndTime()));
        appendSlot(jsonStringBuilder, span);
        return jsonStringBuilder.toString();
    }

    private void appendSlot(JsonStringBuilder jsonStringBuilder, SofaTracerSpan sofaTracerSpan) {

        SofaTracerSpanContext context = sofaTracerSpan.getSofaTracerSpanContext();
        Map<String, String> tagWithStr = sofaTracerSpan.getTagsWithStr();
        Map<String, Number> tagWithNumber = sofaTracerSpan.getTagsWithNumber();
        jsonStringBuilder
            .append(CommonSpanTags.LOCAL_APP, tagWithStr.get(CommonSpanTags.LOCAL_APP));
        //TraceId
        jsonStringBuilder.append(CommonSpanTags.TRACE_ID, context.getTraceId());
        //RpcId
        jsonStringBuilder.append(CommonSpanTags.SPAN_ID, context.getSpanId());
        //请求 URL
        jsonStringBuilder.append(CommonSpanTags.REQUEST_URL,
            tagWithStr.get(CommonSpanTags.REQUEST_URL));
        //Request method
        jsonStringBuilder.append(CommonSpanTags.METHOD, tagWithStr.get(CommonSpanTags.METHOD));
        //Http code
        jsonStringBuilder.append(CommonSpanTags.RESULT_CODE,
            tagWithStr.get(CommonSpanTags.RESULT_CODE));
        Number requestSize = tagWithNumber.get(CommonSpanTags.REQ_SIZE);
        //Request Body Size (byte)
        jsonStringBuilder.append(CommonSpanTags.REQ_SIZE,
            (requestSize == null ? 0L : requestSize.longValue()));
        Number responseSize = tagWithNumber.get(CommonSpanTags.RESP_SIZE);
        //Response Body Size，(byte)
        jsonStringBuilder.append(CommonSpanTags.RESP_SIZE, (responseSize == null ? 0L
            : responseSize.longValue()));
        //Request time (MS)
        jsonStringBuilder.append(CommonSpanTags.TIME_COST_MILLISECONDS,
            (sofaTracerSpan.getEndTime() - sofaTracerSpan.getStartTime()));
        jsonStringBuilder.append(CommonSpanTags.CURRENT_THREAD_NAME,
            tagWithStr.get(CommonSpanTags.CURRENT_THREAD_NAME));
        jsonStringBuilder.appendEnd(CommonSpanTags.BAGGAGE, baggageSerialized(context));
    }
}