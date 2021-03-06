/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.jena.security;

import java.util.Set;

public class StaticSecurityEvaluator implements SecurityEvaluator {

	private String user;
	
	public StaticSecurityEvaluator( String user) {
		this.user = user;
	}
	
	public void setUser( String user )
	{
		this.user = user;
	}

	@Override
	public boolean evaluate(final Object principal, Action action, SecNode graphIRI) {
		return true;
	}

	@Override
	public boolean evaluate(final Object principal, Action action, SecNode graphIRI, SecTriple triple) {
		return triple.getSubject().getValue().equals( "urn:"+principal );
	}

	@Override
	public boolean evaluate(final Object principal, Set<Action> actions, SecNode graphIRI) {
		return true;
	}

	@Override
	public boolean evaluate(final Object principal, Set<Action> actions, SecNode graphIRI,
			SecTriple triple) {
		return triple.getSubject().getValue().equals( "urn:"+principal );
	}

	@Override
	public boolean evaluateAny(final Object principal, Set<Action> actions, SecNode graphIRI) {
		return true;
	}

	@Override
	public boolean evaluateAny(final Object principal, Set<Action> actions, SecNode graphIRI,
			SecTriple triple) {
		return triple.getSubject().getValue().equals( "urn:"+principal );
	}

	@Override
	public boolean evaluateUpdate(final Object principal, SecNode graphIRI, SecTriple from, SecTriple to) {
		return from.getSubject().getValue().equals( "urn:"+principal ) && 
				to.getSubject().getValue().equals( "urn:"+principal );
	}

	@Override
	public Object getPrincipal() {
		return user;
	}

}
