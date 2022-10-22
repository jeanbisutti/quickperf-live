/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2021-2022 the original author or authors.
 */
package org.quickperf.web.spring.testgeneration;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaClassNameGeneratorTest {

    @Test public void
    base_test() {
        assertThat(ClassNameGenerator.INSTANCE.generateClassNameFrom("/api/owners"))
                .isEqualTo("ApiOwnersTest");
    }

    @Test public void
    url_question_mark_and_equal() {
        assertThat(ClassNameGenerator.INSTANCE.generateClassNameFrom("/owners?lastName="))
                .isEqualTo("OwnersLastNameTest");
    }

    @Test public void
    url_with_star() {
        assertThat(ClassNameGenerator.INSTANCE.generateClassNameFrom("/api/owners/*/lastname/e"))
                .isEqualTo("ApiOwnersLastnameETest");
    }

    @Test public void
    html_url() {
        assertThat(ClassNameGenerator.INSTANCE.generateClassNameFrom("/vets.html"))
                .isEqualTo("VetsHtmlTest");
    }

    @Test public void
    url_with_dash() {
        assertThat(ClassNameGenerator.INSTANCE.generateClassNameFrom("/external-call"))
                .isEqualTo("ExternalCallTest");
    }

    @Test public void
    url_finishing_with_slash() {
        assertThat(ClassNameGenerator.INSTANCE.generateClassNameFrom("/owners/"))
                .isEqualTo("OwnersTest");
    }

    @Test public void
    root_url() {
        assertThat(ClassNameGenerator.INSTANCE.generateClassNameFrom("/"))
                .isEqualTo("RootUrlTest");
    }

}