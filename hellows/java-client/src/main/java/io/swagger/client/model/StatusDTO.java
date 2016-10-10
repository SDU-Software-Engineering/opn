/**
 * HelloWorld but no Goodbye
 * A minimal example of an OpenAPI web service
 *
 * OpenAPI spec version: v1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
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


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * Information about the current status of the server
 */
@ApiModel(description = "Information about the current status of the server")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-10T20:47:58.607Z")
public class StatusDTO   {
  @SerializedName("helloCount")
  private Integer helloCount = null;

  public StatusDTO helloCount(Integer helloCount) {
    this.helloCount = helloCount;
    return this;
  }

   /**
   * Gets the name of the user
   * @return helloCount
  **/
  @ApiModelProperty(example = "null", value = "Gets the name of the user")
  public Integer getHelloCount() {
    return helloCount;
  }

  public void setHelloCount(Integer helloCount) {
    this.helloCount = helloCount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatusDTO statusDTO = (StatusDTO) o;
    return Objects.equals(this.helloCount, statusDTO.helloCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(helloCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatusDTO {\n");
    
    sb.append("    helloCount: ").append(toIndentedString(helloCount)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

