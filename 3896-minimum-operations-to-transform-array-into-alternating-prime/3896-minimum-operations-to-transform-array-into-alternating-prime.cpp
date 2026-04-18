class Solution {
public:
    int minOperations(vector<int>& nums) {
        int n = nums.size();
        int mv = 200000;
        vector<bool> ip(mv + 1, true);
        ip[0] = ip[1] = false;
        
        for(int p = 2; p * p <= mv; p++) {
            if(ip[p]) {
                for(int i = p * p; i <= mv; i+= p)
                    ip[i] = false;
            }
        }
        vector<int> p;
        for(int i = 2; i <= mv; i++){
            if(ip[i]) p.push_back(i);
        }
        int to = 0;
        for(int i = 0; i < n; i++){
            if(i % 2 == 0) {
        
                 if(!ip[nums[i]]) {
                 
                             auto it = lower_bound(p.begin(), p.end(), nums[i]);
                             to+=(*it - nums[i]);
                        }
                    }else {
                        int curr = nums[i];
                        while(ip[curr]) {
                            curr++;
                            to++;
                        }
                    }
                }
                return to;
            
            
        
        
    }
};