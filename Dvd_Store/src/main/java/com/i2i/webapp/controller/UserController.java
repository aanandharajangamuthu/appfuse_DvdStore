package com.i2i.webapp.controller;

import com.i2i.Constants;
import com.i2i.dao.SearchException;
import com.i2i.exception.UserApplicationException;
import com.i2i.model.Cart;
import com.i2i.model.Category;
import com.i2i.model.Disc;
import com.i2i.model.Language;
import com.i2i.model.PurchaseOrder;
import com.i2i.model.Role;
import com.i2i.model.User;
import com.i2i.service.CartService;
import com.i2i.service.CategoryService;
import com.i2i.service.DiscService;
import com.i2i.service.LanguageService;
import com.i2i.service.PurchaseOrderService;
import com.i2i.service.UserManager;
import com.i2i.service.UserService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * Simple class to retrieve a list of users from the database.
 * <p/>
 * <p>
 * <a href="UserController.java.html"><i>View Source</i></a>
 * </p>
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Controller
public class UserController {
    private UserManager userManager = null;
    
    @Autowired
    UserService userService;
    
    @Autowired
    UserManager usermanager; 
    
    @Autowired
    CategoryService categoryService;
    
    @Autowired
    LanguageService languageService;
    
    @Autowired
    DiscService discService;
    
    @Autowired
    CartService cartService;
    
	@Autowired
	PurchaseOrderService purchaseOrderService;
	
	static double totalAmount ;
	private static Set<Cart> carts = new HashSet<Cart> ();
	
	private User currentUser = null;	
	PurchaseOrder purchaseOrder = null;


    @Autowired
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
    
    @RequestMapping("/admin/users*")
    public ModelAndView handleRequest(@RequestParam(required = false, value = "q") String query) throws Exception {
        Model model = new ExtendedModelMap();
        try {
            model.addAttribute(Constants.USER_LIST, userManager.search(query));
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(userManager.getUsers());
        }
        return new ModelAndView("admin/userList", model.asMap());
    }
    
    
    @RequestMapping("/home")
    public ModelAndView handleHomePage(final HttpServletRequest request) {       
        String userName = request.getRemoteUser();
		System.out.println(userName);
		currentUser = userService.getUserByUsername(userName);		
		System.out.println(currentUser);
		if(null != currentUser){
		    Set<Role> roles = currentUser.getRoles();
			for(Role role : roles){
			    if("ROLE_ADMIN".equals(role.getName())){
				    return new ModelAndView("adminPage");
			    }
		    }
		}
		    return new ModelAndView("homeIndex");
		
    }
    
    @RequestMapping("/userIndex")
    public ModelAndView getIndex(){
    	return new ModelAndView("homeIndex");
    }
    
 // Category Controller
	
 	/**
 	 * <p> Registers the new category by the admin</p> 
 	 * @param category
 	 *        Category object to be added into the database
 	 * @param result
 	 * @return categoryRegister page
 	 *         Asks for category to be registered
 	 */
 	@RequestMapping("/registerCategory")
 	public ModelAndView getRegisterForm(@ModelAttribute("category") Category category,
 			BindingResult result) {
 		System.out.println("Register category Form");
 		return new ModelAndView("categoryRegister");
 	}
 	
 	/**
 	 * <p> Saves the category details into the database & redirects to categoryDetails Page
 	 * @param category
 	 *        Category object
 	 * @param result
 	 * @return CategoryDetails Page 
 	 *         shows the list of categories
 	 */
 	@RequestMapping("/saveCategory")
 	public ModelAndView saveUserData(@ModelAttribute("category") Category category,
 			BindingResult result) {
 		try {
 			categoryService.createCategory(category);
 			return new ModelAndView("redirect:/categoryList.html");
 		} catch (UserApplicationException e) {			
 			e.getMessage();
 		}
 		return null;		
 	}
 	
	/**
	 * <p>Retrieves the list of categories from the database & directs to categoryDetails page</p> 
	 * @return categoryDetails Page
	 *         shows the list of categories
	 */
	@RequestMapping("/categoryList")
	public ModelAndView getCategoryList() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("category", categoryService.categoryList());
			return new ModelAndView("categoryDetails", model);
		} catch (UserApplicationException e) {
			
			e.printStackTrace();
		}
		return null;
    }
	
	// Language Controller
	/**
	 * <p> Registers the new language by the admin</p> 
	 * @param language
	 *        Language object to be added into the database
	 * @param result
	 * @return languageRegister page
	 *         ask for language to be registered
	 */	
	@RequestMapping("/registerLanguage")
	public ModelAndView getRegisterForm(@ModelAttribute("language") Language language,
			BindingResult result) {
		System.out.println("Register Form");
		return new ModelAndView("languageRegister");
	}
	
	/**
	 * <p> Saves the language details into the database & redirects to categoryDetails Page
	 * @param language
	 *        Language object
	 * @param result
	 * @return LangaueDetails Page
	 *         shows list of languages 
	 */
	@RequestMapping("/saveLanguage")
	public ModelAndView saveUserData(@ModelAttribute("language") Language language,
			BindingResult result) {
		try {
			languageService.saveLanguage(language);
			return new ModelAndView("redirect:/languageList.html");
		} catch (UserApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
		return null;		
	}

	/**
	 * <p>Retrieves the list of languages from the database & directs to categoryDetails page</p> 
	 * @return languageDetails Page
	 *         shows list of languages
	 */
	@RequestMapping("/languageList")
	public ModelAndView getLanguageList() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("language", languageService.languageList());
			return new ModelAndView("languageDetails", model);
		} catch (UserApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
	
	/**
	 * <p>
     * This method used to redirect to discRegister page.    
     * <p>
	 * @param disc should not be null
    CategoryService categoryService;

	 * @param result
	 * @return ModelAndView 
	 *          It returns discRegister page.
	 */
	@RequestMapping("/registerDisc")
	public ModelAndView getRegisterForm(@ModelAttribute("disc") Disc disc,
			BindingResult result) {		
		return new ModelAndView("discRegister");
	}	
	
	
	/**
	 * <p>
     * This method used to store new disc.Disc object get from the modelAttribute. 
     * <p>
	 * @param disc object should not be null.
	 * @param result
	 * @return ModelAndView
	 *         returns redirect to discList.
	 */
	@RequestMapping("/saveDisc")
	public ModelAndView saveUserData(@ModelAttribute("disc") Disc disc,
			BindingResult result) {
		try {
			discService.createDisc(disc);
			return new ModelAndView("redirect:/discList.html");
		} catch (UserApplicationException e) {
			e.printStackTrace();
			System.out.println(e);			
		}	
		return null;
	}	
	
	/**
	 *  <p>
     * This method used to get all discs and shows in disDetails page. 
     * <p> 
	 * @return ModelAndView
	 *          returns discDetails page. 
	 */
	@RequestMapping("/discList")
	public ModelAndView getdiscList() {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			System.out.println("Entering into disc List");
			model.put("disc", discService.discList());
			return new ModelAndView("discDetails", model);
		} catch (UserApplicationException e) {
			e.printStackTrace();
			System.out.println(e);	
		}
		return null;
    }
    
	/**
	 * <p>
     * This method used to redirect to languageAndDisc page for assign language to disc. 
     * <p>
	 * @return ModelAndView
	 *         returns to languageAndDisc page.
	 */
	@RequestMapping("/assignLanguage")
	public ModelAndView showLanguage() { 	
		return new ModelAndView("languageAndDisc");
	}	
	
	/**
	 * <p>
     * This method used to assign language to disc. 
     * <p>
	 * @param discId should be integer,Used to get Disc object.
	 * @param languageId should be integer, Used to get Language object
	 * @return ModelAndView
	 *         returns model to languageAndDisc page.
	 */
	@RequestMapping(value="/allocateLanguage",method=RequestMethod.POST)
	public ModelAndView allocateDisc(@RequestParam("discId") int discId, 
			            @RequestParam("languageId") int languageId) {
		Disc disc;
		Language language;
		try {		
		    disc = discService.findByDiscId(discId);
		    System.out.println(disc);
		    language = languageService.findByLanguageId(languageId);
		    System.out.println(language);
		    Set<Disc> discs = new HashSet<Disc>();
		    discs.add(disc);
			discService.languageForDiscs(discs,language);
			return new ModelAndView("assigned");
		} catch (UserApplicationException e) {	
			e.printStackTrace();
			System.out.println(e);			
		}		
		return null;
	}
	
	/**
	 * <p>
     * This method used to redirect categoryAndDisc page for assign category to disc. 
     * <p> 
	 * @return ModelAndView
	 *         returns to categoryAndDisc page.
	 */
	@RequestMapping("/assignCategory")
	public ModelAndView showCategory() { 	
		return new ModelAndView("categoryAndDisc");
	}		
	
	/**
	 * <p>
     * This method used to assign category to Disc and shows assigned success message page. 
     * <p> 
	 * @param discId should be integer,Used to get Disc object.
	 * @param categoryId should be integer, Used to get Category object
	 * @return ModelAndView 
	 *         returns to assigned page.
	 */
	@RequestMapping(value="/allocateCategory",method=RequestMethod.POST)
	public ModelAndView allocateCategory(@RequestParam("discId") int discId, 
			            @RequestParam("categoryId") int categoryId) {
		Disc disc;
		Category category;
		try {
		    disc = discService.findByDiscId(discId);
		    System.out.println(disc);
		    category = categoryService.findByCategoryId(categoryId);
		    System.out.println(category);
		    Set<Disc> discs = new HashSet<Disc>();
		    discs.add(disc);
			discService.categoryForDiscs(discs,category);
			return new ModelAndView("assigned");
		} catch (UserApplicationException e) {
			e.printStackTrace();
			System.out.println(e);		
		}		
		return null;
	}
	
	// Cart Controller
	
		/**
		 * <Adds the disc details into the cart, calculates the total price & reduces the quantity of disc</p>
		 * @param id
		 *        by which the cart to be inserted into the database
		 * @param stock
		 *        which is the available quantity of disc
		 * @param quantity
		 *        which can be the quantity of disc required by the user
		 * @return Cart page
		 */
		@RequestMapping(value = "addProduct",method = RequestMethod.POST)
		public ModelAndView getCart(@RequestParam("id") int id , @RequestParam("stock") int stock, 
				@RequestParam("quantity") int quantity,@RequestParam("userName") String userName) {
			Map<String, Object> model = new HashMap<String, Object>();		
			try {
				currentUser = userManager.getUserByUsername(userName);
				System.out.println(currentUser);
				stock = stock - quantity;
				Disc disc = discService.findByDiscId(id);			
				double totalPrice  = quantity * disc.getPrice();
				discService.updateByDiscStock(disc,stock);
				Cart cart = new Cart(disc,quantity,totalPrice);			
				cartService.addCart(cart);	
				carts.add(cart);
				totalAmount += totalPrice;
				model.put("cart", currentUser);
				model.put("cart",carts);
				model.put("totalAmount",totalAmount);	
				return new ModelAndView("Cart",model);
			} catch (UserApplicationException e) {
				e.printStackTrace();
				System.out.println(e);
			}		
			return null;
		}
		
		/**
		 * <p> Deletes the cart based on user need & restores the available stock of disc</p>
		 * @param id
		 * @param discId
		 * @param quantity
		 * @return Cart page
		 *         contains the cart detailscom.i2i.model.User@6b328d91[username=user,enabled=true,accountEx
		 */
		@RequestMapping("/deleteCart")
		public ModelAndView deleteCart(@RequestParam("id") int id, @RequestParam("discId") int discId ,@RequestParam("quantity") int quantity) {
			Map<String, Object> model = new HashMap<String, Object>();	
			try {	
				System.out.println(quantity);
				Disc disc = discService.findByDiscId(discId);			
				Cart cart = cartService.getCartById(id);	
				System.out.println("Disc "+disc);
				totalAmount = totalAmount - cart.getTotalPrice();			
				int stock = disc.getStock() + quantity;
				discService.updateByDiscStock(disc,stock);			
				System.out.println("before Set Collections"+carts);			
				Iterator<Cart> cartIterator = carts.iterator();
				while (cartIterator.hasNext()) {
					cart = cartIterator.next();
				    if (cart.getId() ==  id) {
				    	cartIterator.remove();
				    }
				}		    
			    System.out.println("after remove Set Collections"+carts);
			    cartService.removeCartById(id);			
				model.put("cart", carts);	
				model.put("totalAmount",totalAmount);
				return new ModelAndView("Cart",model);
			} catch (UserApplicationException e) {
				e.printStackTrace();
				System.out.println(e);
			}		
			return null;
		}	

	   /**
	    * <p> Retrieves the list of carts</p> 
	    * @return Cart page
	    *         contains the cart details
	    */
		@RequestMapping("/cartList")
		public ModelAndView cartList() {
			Map<String, Object> model = new HashMap<String, Object>();
			double amount = 0;
			for(Cart cart:carts) {				
				amount += cart.getTotalPrice();         
			}
			model.put("cart", carts);			
			model.put("totalAmount", amount);
			return new ModelAndView("Cart", model);
		}
		
		/**
		 * <p> Displays the particular disc detail chosen by the user to buy</p>
		 * @param id
		 *        which can be the id of the disc chosen by the user
		 * @return buyDisc Page
		 *        contains disc details chosen by the user
		 */
		@RequestMapping("/buyDisc")
		public ModelAndView buyDisc(@RequestParam("id") int id) {
			Map<String, Object> model = new HashMap<String, Object>();		
			try {
				System.out.println("entering into Buy Disc");
				Disc disc = discService.findByDiscId(id);			
				model.put("BuyDisc", disc);
				//model.put("BuyDisc", currentUser);
				return new ModelAndView("buyDisc", model);
			} catch (UserApplicationException e) {
				e.printStackTrace();
				System.out.println(e);		
			}
			return null;
		}
		
		/**
		 * <p> Redirects to purchaseDisc page</P>
		 * @param user
		 *        User object 
		 * @param result
		 * @return ModelAndView
		 *         redirects to purchaseDisc page
		 */
	/*	@RequestMapping("/purchase")
		public ModelAndView getPurchase() {
		    return new ModelAndView("redirect:/purchaseDisc.html");
		}*/
		
		/**
		 * <p> Redirects to purchase order page based on login status of user</p>
		 * @param user
		 *        User object
		 * @param result
		 * @return purchaseOrder page
		 *         when the user already logged in & chosen the disc to purchase
		 */
		@RequestMapping("/purchaseDisc")
		public ModelAndView checkUser() {
			System.out.println("Entering into PurchaseDisc");
			Map<String, Object> model = new HashMap<String, Object>();		
			purchaseOrder = new PurchaseOrder(carts,currentUser);	
			System.out.println("currentUser");
			System.out.println(purchaseOrder.getId());
			model.put("totalAmount", totalAmount);	
			model.put("cart", purchaseOrder.getCart());
			model.put("order", purchaseOrder);
			return new ModelAndView("PurchaseOrder",model);
        }	
		
		/**
		 * <p>Redirects to Success page when the user confirms the purchase order, clears the cart
		 * details added by the user & subtracts the required quantity of disc from the available quantity
		 * of disc
		 * </P>
		 * @return Success page
		 *         shows Success message
		 */
		@RequestMapping("/success")
		public ModelAndView conformPurchase() {		
			 System.out.println("Sucess");	
			 totalAmount = 0;
			 Map<String, Object> model = new HashMap<String, Object>();	
			 model.put("currentUser", currentUser);
			try {				
				System.out.println(purchaseOrder);
				purchaseOrderService.add(purchaseOrder);	
				System.out.println(purchaseOrder);
				for(Cart cart:purchaseOrder.getCart()) {				
					cartService.updateCart(cart, purchaseOrder);	           
				}
				carts.clear();
				return new ModelAndView("Success",model);
			} catch (UserApplicationException e) {
				e.printStackTrace();
				System.out.println(e);			
			}
			return null;
		}
		
		/**
		 * <p>
	     * This method used to show all movies. 
	     * <p>
		 * @return ModelAndView
		 *         returns model to movies page.
		 */
		@RequestMapping(value="/movieList")
		public ModelAndView getMovies() {
			System.out.println("entering into movie");
			Map<String, Object> model = new HashMap<String, Object>();
			try {
				System.out.println("Entering after map");
				model.put("disc", discService.discList());
				return new ModelAndView("movies", model);
			} catch (UserApplicationException e) {
				e.printStackTrace();
				System.out.println(e);	
			}
			return null;
	    }	
		
		/**
		 * <p>
	     * This method used to show only tamil movies from movies list. 
	     * <p>
		 * @return ModelAndView
		 *         returns model to tamil page.
		 */
		@RequestMapping("/tamilMovies")
		public ModelAndView getTamilMovies() {
			Map<String, Object> model = new HashMap<String, Object>();
			try {
				model.put("disc", discService.discList());
				return new ModelAndView("tamil", model);
			} catch (UserApplicationException e) {
				e.printStackTrace();
				System.out.println(e);	
			}
		    return null;	
	    }
		
		
		/**
		 * <p>
	     * This method used to show only english movies from movies list. 
	     * <p> 
		 * @return ModelAndView
		 *         returns model to english page.
		 */
		@RequestMapping("/englishMovies")
		public ModelAndView getEnglishMovies() {
			Map<String, Object> model = new HashMap<String, Object>();
			try {
				model.put("disc", discService.discList());
				return new ModelAndView("english", model);
			} catch (UserApplicationException e) {
				e.printStackTrace();
				System.out.println(e);	
			}
			return null;
	    }
		
		/**
		 * <p>
	     * This method used to show only hindi movies from movies list. 
	     * <p> 
		 * @return ModelAndView
		 *          returns model to hindi page. 
		 */
		@RequestMapping("/hindiMovies")
		public ModelAndView getHindiMovies() {
			Map<String, Object> model = new HashMap<String, Object>();
			try {
				model.put("disc", discService.discList());
				return new ModelAndView("hindi", model);
			} catch (UserApplicationException e) {
				e.printStackTrace();
				System.out.println(e);	
			}
			return null;
	    }	
		
		/**
		 * <p>
	     * This method used to show songs list. 
	     * <p>
		 * @return ModelAndView
		 *         returns model to songs page. 
		 */
		@RequestMapping("/songList")
		public ModelAndView getSongs() {
			Map<String, Object> model = new HashMap<String, Object>();
			try {
				model.put("disc", discService.discList());
				return new ModelAndView("songs", model);
			} catch (UserApplicationException e) {	
				e.printStackTrace();
				System.out.println(e);	
			}
			return null;
	    }
		
		
		/**
		 * <p>
	     * This method used to list only tamil songs list. 
	     * <p>
		 * @return ModelAndView
		 *         returns model to tamilSong page. 
		 */
		@RequestMapping("/tamilSongs")
		public ModelAndView getTamilSongs() {
			Map<String, Object> model = new HashMap<String, Object>();
			try {
				model.put("disc", discService.discList());
				return new ModelAndView("tamilSong", model);
			} catch (UserApplicationException e) {
				e.printStackTrace();
				System.out.println(e);	
				return null;
			}		
	    }
		
		/**
		 * <p>
	     * This method used to list only tamil songs list. 
	     * <p> 
		 * @return ModelAndView 
		 *         returns model to hindiSong page. 
		 */
		@RequestMapping("/hindiSongs")
		public ModelAndView getHindiSongs() {
			Map<String, Object> model = new HashMap<String, Object>();
			try {
				model.put("disc", discService.discList());
				return new ModelAndView("hindiSong", model);
			} catch (UserApplicationException e) {
				e.printStackTrace();
				System.out.println(e);	
			}
			return null;
	    }	

		/**
	     * <p>
	     * This method used to list only english songs list. 
	     * <p>     
		 * @return ModelAndView
		 *         returns model to englishSong page.
		 */
		@RequestMapping("/englishSongs")
		public ModelAndView getEnglishSongs() {
			Map<String, Object> model = new HashMap<String, Object>();
			try {
				model.put("disc", discService.discList());
				return new ModelAndView("englishSong", model);
			} catch (UserApplicationException e) {
				e.printStackTrace();
				System.out.println(e);
				return null;
			}
			
	    }	

		/**
		 * <p>
	     * This method used to list all langauge shows. 
	     * <p> 
		 * @return ModelAndView 
		 *         returns model to shows page.
		 */
		@RequestMapping("/showList")
		public ModelAndView getShows() {
			Map<String, Object> model = new HashMap<String, Object>();
			try {
				model.put("disc", discService.discList());
				return new ModelAndView("shows", model);
			} catch (UserApplicationException e) {
				e.printStackTrace();
				System.out.println(e);	
				return null;
			}
			
	    }
		
		/**
		 * <p>
	     * This method used to list the tamil tv shows. 
	     * <p> 
		 * @return ModelAndView 
		 *         returns model to tamilTvShows page.
		 */
		@RequestMapping("/tamilShows")
		public ModelAndView getTamilShows() {
			Map<String, Object> model = new HashMap<String, Object>();
			try {
				model.put("disc", discService.discList());	
				return new ModelAndView("tamilTvShows", model);
			} catch (UserApplicationException e) {
				e.printStackTrace();
				System.out.println(e);	
				return null;
			}
			
	    }
		
		
		/**
		 * <p>
	     * This method used to list the english shows. 
	     * <p>
		 * @return ModelAndView 
		 *         returns model to english_Shows page.
		 */
		@RequestMapping("/englishShows")
		public ModelAndView getEnglishShows() {
			Map<String, Object> model = new HashMap<String, Object>();
			try {
				model.put("disc", discService.discList());		
				return new ModelAndView("english_Shows", model);
			} catch (UserApplicationException e) {
				e.printStackTrace();
				System.out.println(e);	
				return null;
			}
			
	    }  
		
		/**
		 * <p>
	     * This method used to list the hindi shows. 
	     * <p>
		 * @return ModelAndView
		 *         returns model to hindi_Shows page.
		 */
		@RequestMapping("/hindiShows")
		public ModelAndView getHindiShows() {
			Map<String, Object> model = new HashMap<String, Object>();
			try {
				model.put("disc", discService.discList());			 
				return new ModelAndView("hindi_Shows", model);
			} catch (UserApplicationException e) {
				e.printStackTrace();
				System.out.println(e);	
				return null;
			}
			
	    }	
}
