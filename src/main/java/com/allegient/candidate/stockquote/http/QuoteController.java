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
package com.allegient.candidate.stockquote.http;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.allegient.candidate.stockquote.app.QuoteFinder;
import com.allegient.candidate.stockquote.domain.QuoteList;

@RestController
public class QuoteController {

    @Autowired
    private QuoteFinder quoteFinder;

    @CrossOrigin(origins="*")
    @RequestMapping(value="/quote", method={RequestMethod.GET})
    public QuoteList quote(@RequestParam(value = "symbols") List<String> symbols) {
        return quoteFinder.find(symbols.stream());
    }
}
