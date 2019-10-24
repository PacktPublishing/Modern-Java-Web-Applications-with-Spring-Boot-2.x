package org.ceva.products;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.ceva.products.model.OrderProduct;
import org.ceva.products.model.PaymentProduct;
import org.ceva.products.repository.OrderRepository;
import org.ceva.products.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = 
  SpringBootTest.WebEnvironment.MOCK,
  classes = CevaApplication.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class OrderPaymentWebMockTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void testPostAddOrder() throws Exception{
		OrderProduct order1 = new OrderProduct();
		order1.setId(203L);
		order1.setPid(101L);
		order1.setQty(5);
		order1.setAmount(5000.00);
		order1.setOrderId(1003L);
		order1.setStatus("created");
		
		
				
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/ceva/order/add")
                .content(objectMapper.writeValueAsString(order1))
				.contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
                .andReturn();

        MockHttpServletResponse respStatus = result.getResponse();
        assertNotNull(respStatus);
        System.out.println(result.getResponse().getContentAsString());
	}
	
	@Test
	public void testPostConfirmedPayment() throws Exception{
		PaymentProduct payment1 = new PaymentProduct();
		payment1.setId(503L);
		payment1.setOrderId(1001L);
		payment1.setTotalAmount(15000.00);
		payment1.setTotalDue(10000.00);
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/ceva/payment/add")
                .content(objectMapper.writeValueAsString(payment1))
				.contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
                .andReturn();

        MockHttpServletResponse respStatus = result.getResponse();
        assertNotNull(respStatus);
        System.out.println(result.getResponse().getContentAsString());
	}
	
	@Test
	public void testPostDeclinedPayment() throws Exception{
		PaymentProduct payment1 = new PaymentProduct();
		payment1.setId(502L);
		payment1.setOrderId(1000L);
		payment1.setTotalAmount(20000.00);
		payment1.setTotalDue(30000.00);
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/ceva/payment/add")
                .content(objectMapper.writeValueAsString(payment1))
				.contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
                .andReturn();

        MockHttpServletResponse respStatus = result.getResponse();
        assertNotNull(respStatus);
        System.out.println(result.getResponse().getContentAsString());
	}
	
	@Test
	public void testGetOrderDelivery() throws Exception{
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
				                         .get("/ceva/order/delivery/{order_id}","1001")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
	}
	
	
	

}
