package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Information about the current status of the server
 **/

/**
 * Information about the current status of the server
 */
@ApiModel(description = "Information about the current status of the server")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-10T20:46:37.180Z")
public class StatusDTO   {
  private Integer helloCount = null;

  public StatusDTO helloCount(Integer helloCount) {
    this.helloCount = helloCount;
    return this;
  }

   /**
   * Gets the name of the user
   * @return helloCount
  **/
  @ApiModelProperty(value = "Gets the name of the user")
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

