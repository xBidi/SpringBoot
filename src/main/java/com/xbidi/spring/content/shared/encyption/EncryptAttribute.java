package com.xbidi.spring.content.shared.encyption;

import com.xbidi.spring.content.shared.output.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;

/**
 * Attribute encryption
 *
 * @author diegotobalina
 */
@Slf4j
@Component
public class EncryptAttribute implements AttributeConverter<String, String> {

  private static final String KEY = "0000000000000000000000000000000F";
  private static final String AAD = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
  private static final EncryptManager encryptManager = new EncryptManager(KEY.getBytes(), AAD);

  @Override
  public String convertToDatabaseColumn(String attribute) {
    try {
      return encryptManager.encrypt(attribute);
    } catch (Exception ex) {
      new ErrorResponse(ex, 500).printMessage();
    }
    return null;
  }

  @Override
  public String convertToEntityAttribute(String dbData) {
    try {
      return encryptManager.decrypt(dbData);
    } catch (Exception ex) {
      new ErrorResponse(ex, 500).printMessage();
    }
    return null;
  }
}