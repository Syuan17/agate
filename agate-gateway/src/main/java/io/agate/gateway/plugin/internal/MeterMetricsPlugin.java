/*
 * Copyright (C) 2020~2022 dinstone<dinstone@163.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
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
package io.agate.gateway.plugin.internal;

import io.agate.gateway.handler.OperationHandler;
import io.agate.gateway.handler.internal.MeterMetricsHandler;
import io.agate.gateway.options.RouteOptions;
import io.agate.gateway.plugin.PluginOptions;
import io.agate.gateway.plugin.RoutePlugin;
import io.micrometer.core.instrument.MeterRegistry;
import io.vertx.core.Vertx;
import io.vertx.micrometer.backends.BackendRegistries;

public class MeterMetricsPlugin extends RoutePlugin {

    public MeterMetricsPlugin(RouteOptions routeOptions, PluginOptions pluginOptions) {
        super(routeOptions, pluginOptions);
    }

    @Override
    public OperationHandler createHandler(Vertx vertx) {
        MeterRegistry meterRegistry = BackendRegistries.getDefaultNow();
        return new MeterMetricsHandler(routeOptions, meterRegistry);
    }

}
