//package com.example.airlineproject.config;

//@Component
//@AllArgsConstructor
//public class JwtAuthFilter extends OncePerRequestFilter {
//
//    private final UserDetailsService userDetailsService;
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        final String authHeader = request.getHeader(AUTHORIZATION);
//        final String userEmail;
//        final String jwtToken;
//
//        if (authHeader == null || !authHeader.startsWith("bearer")){
//           filterChain.doFilter(request, response);
//        }
//        assert authHeader != null;
//        jwtToken = authHeader.substring(7);
//        userEmail = "something";
//        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null){
//            UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);
//            final boolean isTokenValid;
//            if (isTokenValid){
//                UsernamePasswordAuthenticationToken authToken =
//                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authToken);
//            }
//        }
//        filterChain.doFilter(request, response);
//    }
//}
