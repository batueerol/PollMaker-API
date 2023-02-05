package com.example.pollmaker.mapper;

import com.example.pollmaker.domain.Option;
import com.example.pollmaker.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OptionMapperTest {

    private OptionMapper optionMapper;

    @BeforeEach
    void setUp() {
        optionMapper = new OptionMapper();
    }

    @Test
    void stringToOption_WhenParameterIsNull_ReturnsNull() {
        List<Option> result = optionMapper.stringToOption(null);
        Assertions.assertNull(result);
    }

    @Test
    void stringToOption_WhenParameterIsValid_ReturnsOptionList() {
        List<String> parameter = TestUtil.getOptionListForStringToOptionTest();
        List<Option> result = optionMapper.stringToOption(parameter);

        assertEquals(0, result.get(0).getVoteCount());
        assertEquals(parameter.get(0), result.get(0).getValue());
    }

}