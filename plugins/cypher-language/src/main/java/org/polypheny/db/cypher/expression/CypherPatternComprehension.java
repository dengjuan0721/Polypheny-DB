/*
 * Copyright 2019-2023 The Polypheny Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.polypheny.db.cypher.expression;

import lombok.Getter;
import org.polypheny.db.cypher.pattern.CypherPattern;
import org.polypheny.db.languages.ParserPos;

@Getter
public class CypherPatternComprehension extends CypherExpression {

    private final ParserPos patternPos;
    private final CypherPattern pattern;
    private final CypherVariable variable;
    private final CypherExpression where;
    private final CypherExpression projection;


    public CypherPatternComprehension( ParserPos pos, ParserPos patternPos, CypherPattern pattern, CypherVariable variable, CypherExpression where, CypherExpression projection ) {
        super( pos );
        this.patternPos = patternPos;
        this.pattern = pattern;
        this.variable = variable;
        this.where = where;
        this.projection = projection;
    }

}
