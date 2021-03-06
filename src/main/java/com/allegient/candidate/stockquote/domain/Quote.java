/**
 *    Copyright 2017 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.allegient.candidate.stockquote.domain;

public class Quote {
    private final String symbol;
    private final double lastTradePrice;

    public static Quote of(String symbol, double lastTradePrice) {
        return new Quote(symbol, lastTradePrice);
    }

    private Quote(String symbol, double lastTradedPrice) {
        this.symbol = symbol;
        this.lastTradePrice = lastTradedPrice;
    }

    public Quote update(double updatedPrice) {
        return Quote.of(getSymbol(), updatedPrice);
    }

    public String getSymbol() {
        return symbol;
    }

    public double getLastTradePrice() {
        return lastTradePrice;
    }
}
