package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.refdata.FinancialStatus;
import pl.zankowski.iextrading4j.api.refdata.IssueEvent;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IssueEventDeserializerTest {

    private IssueEventDeserializer deserializer;

    @Before
    public void setUp() {
        deserializer = new IssueEventDeserializer();
    }

    @After
    public void tearDown() {
        deserializer = null;
    }

    @Test
    public void shouldReturnUnknownTypeIfValueIsNull() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn(null);

        final IssueEvent result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(IssueEvent.UNKNOWN);
    }

    @Test
    public void shouldCreateEnumBasedOnValue() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn("FS");

        final IssueEvent result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(IssueEvent.FINANCIAL_STATUS_CHANGE);
    }
}
