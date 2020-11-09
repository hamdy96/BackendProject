package main;

import main.models.Menu;
import main.models.Order;
import main.models.Role;
import main.models.User;
import main.security.services.UserDetailsServiceImpl;
import main.service.*;
import main.repository.*;
import main.security.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.*;

import static main.models.ERole.ROLE_ADMIN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
class BackendApplicationTests {

	@Autowired
	MenuService ms ;

	@Autowired
	OrderService os ;

	@Autowired
	MenuRepository mr;

	@Autowired
	OrderRepository or;

	@Test
	public void GetAllMenuTest() {
		when(mr.findAll()).thenReturn(
				new ArrayList<Menu>(Arrays.asList(
						new Menu(1, "chicken ranch", 200, "img1"),
						new Menu(2, "bbq", 200, "img2"),
						new Menu(3, "6 cheese", 200, "img3"),
						new Menu(4, "seafood", 200, "img4"))) {
				});
		List<Menu> expected = mr.findAll();
		List<Menu> actual = ms.getAll();
		assertEquals(expected, actual);
	}


	@Test
	public void postMenuItem() {
		Menu item = new Menu(1, "Chicken Ranch", 200, "img1");
		mr.save(item);
		when(mr.findByName("Chicken Ranch")).thenReturn(item);
		Menu actual = ms.findByName("Chicken Ranch");
		assertEquals(item, actual);
	}


	@Test
	public void test()
	{
		Role role = new Role(ROLE_ADMIN);
		Set<Role> roles = new HashSet<Role>();

		List<Menu> items = new ArrayList<Menu>();

		User user = new User("hassan","hassan@gmail.com","1234");
		Menu item = new Menu(1, "Chicken Ranch", 200, "img1");

		items.add(item);
		roles.add(role);

		Order order = new Order(1,user,200,items);

		when(mr.findByName("Chicken Ranch")).thenReturn(item);
		when(or.findById(1)).thenReturn(Optional.of(order));

		ms.newMenu(item);
		os.newOrder(order);

		Menu itemActual = ms.findByName("Chicken Ranch");
		//Order orderActual = os.getOrderById(1);

		assertEquals(item,itemActual);
		//assertEquals(order,orderActual);
	}
}
