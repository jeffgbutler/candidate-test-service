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
package com.allegient.candidate.stockquote.datasource;

import org.springframework.beans.factory.annotation.Autowired;

import com.allegient.candidate.stockquote.domain.Quote;

public class FakeQuoteGenerator {

    @Autowired
    public RandomPriceGenerator pricer;

    public Quote create(String symbol) {
        return Quote.of(symbol, pricer.create());
    }

    public Quote update(Quote quote) {
        double updatedPrice = pricer.update(quote.getLastTradePrice());
        return quote.update(updatedPrice);
    }
}
