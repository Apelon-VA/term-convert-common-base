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

import org.ihtsdo.otf.tcc.api.refexDynamic.data.RefexDynamicDataType;

/**
 * Invented property with special handling for root node in workbench.
 * 
 * @author Daniel Armbrust
 */
public class BPT_ContentVersion extends PropertyType
{
	public Property RELEASE;
	public Property LOADER_VERSION;

	public BPT_ContentVersion()
	{
		super("Content Version", true, RefexDynamicDataType.STRING);
		RELEASE = addProperty("Release");
		LOADER_VERSION = addProperty("Loader Version");
	}
}
