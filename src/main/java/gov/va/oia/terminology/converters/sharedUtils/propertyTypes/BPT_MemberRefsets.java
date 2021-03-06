/**
 * Copyright Notice
 *
 * This is a work of the U.S. Government and is not subject to copyright
 * protection in the United States. Foreign copyrights may apply.
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
package gov.va.oia.terminology.converters.sharedUtils.propertyTypes;

import java.util.HashMap;
import org.ihtsdo.otf.tcc.dto.TtkConceptChronicle;

/**
 * Fields to treat as refsets
 * 
 * @author Daniel Armbrust
 * 
 */
public class BPT_MemberRefsets extends PropertyType
{
	private HashMap<String, TtkConceptChronicle> conceptMap_;  //We store concepts here, because by their nature, refsets can't be written until they are populated
	//this happens much later in the conversion cycle.
	private TtkConceptChronicle refsetIdentityParent_;  //Typically "Term-name Refsets" under "Project Refsets"

	public BPT_MemberRefsets(String terminologyName)
	{
		super("Refsets", terminologyName + " Refsets", true, null);
		conceptMap_ = new HashMap<>();
	}
	
	public TtkConceptChronicle getConcept(String propertyName)
	{
		return getConcept(getProperty(propertyName));
	}
	
	public TtkConceptChronicle getConcept(Property property)
	{
		return conceptMap_.get(property.getSourcePropertyNameFSN());
	}
	
	public void clearConcepts()
	{
		conceptMap_.clear();
	}
	
	public void setRefsetIdentityParent(TtkConceptChronicle refsetIdentityParent)
	{
		refsetIdentityParent_ = refsetIdentityParent; 
	}
	
	public TtkConceptChronicle getRefsetIdentityParent()
	{
		return refsetIdentityParent_;
	}

	@Override
	public void conceptCreated(Property p, TtkConceptChronicle concept)
	{
		super.conceptCreated(p, concept);
		conceptMap_.put(p.getSourcePropertyNameFSN(), concept);
	}
}
