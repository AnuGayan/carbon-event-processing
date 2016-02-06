/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.siddhi.metrics.core;

import org.wso2.siddhi.core.util.statistics.*;
import org.wso2.siddhi.query.api.annotation.Element;

import java.util.List;

/**
 * Factory to retrieve required metric tracker.
 */
public class SiddhiMetricsFactory implements StatisticsTrackerFactory {
    private boolean statisticsEnabled = false;

    public SiddhiMetricsFactory(boolean isStatisticsEnabled) {
        statisticsEnabled = isStatisticsEnabled;
    }

    public LatencyTracker createLatencyTracker(String name, StatisticsManager statisticsManager) {
        return new SiddhiLatencyMetric(name, statisticsEnabled);
    }

    public ThroughputTracker createThroughputTracker(String name, StatisticsManager statisticsManager) {
        return new SiddhiThroughputMetric(name, statisticsEnabled);
    }

    public MemoryUsageTracker createMemoryUsageTracker(StatisticsManager statisticsManager) {
        return new SiddhiMemoryUsageMetric(statisticsEnabled);
    }

    @Override
    public StatisticsManager createStatisticsManager(List<Element> elements) {
        return new SiddhiStatisticsManager(elements);
    }
}
